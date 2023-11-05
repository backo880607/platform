package com.pisces.platform.user.token;

import com.pisces.framework.core.entity.AccountData;
import com.pisces.framework.core.utils.AppUtils;
import com.pisces.framework.core.utils.lang.Guard;
import com.pisces.framework.core.utils.lang.StringUtils;
import com.pisces.framework.web.context.PiscesContext;
import com.pisces.framework.web.context.PiscesRequest;
import com.pisces.framework.web.context.PiscesResponse;
import com.pisces.framework.web.token.JwtTokenHelper;
import com.pisces.platform.user.config.TokenConfig;
import com.pisces.platform.user.config.UserMessage;
import com.pisces.platform.user.token.dao.SaTokenDao;
import com.pisces.platform.user.token.session.SaSession;
import com.pisces.platform.user.token.session.TokenSign;

/**
 * 登录助手
 *
 * @author jason
 * @date 2023/07/26
 */
public class LoginHelper {

    /**
     * 返回全局配置对象
     *
     * @return /
     */
    public TokenConfig getConfig() {
        // 为什么再次代理一层? 为某些极端业务场景下[需要不同StpLogic不同配置]提供便利
        return TokenManager.getConfig();
    }

    public SaTokenDao getTokenDao() {
        return TokenManager.getSaTokenDao();
    }

    public void login(LoginModel model) {
        String token = createLoginSession(model.getAccountData(), model.getDevice());
        setTokenValue(token);
    }

    private String createLoginSession(AccountData data, String device) {
        Guard.assertNotEmpty(data.getAccount(), UserMessage.AccountBlank);
        String token = distUsableToken(data, device);
        SaSession session = getSessionByAccount(data.getAccount(), true);
        TokenSign tokenSign = new TokenSign();
        tokenSign.setToken(token);
        tokenSign.setDevice(device);
        session.addTokenSign(tokenSign);
        return token;
    }

    private void setTokenValue(String token) {
        PiscesResponse response = AppUtils.getBean(PiscesContext.class).getResponse();
        response.addHeader("Authorization", "Bearer " + token);
    }

    /**
     * 为指定账号id的登录操作，分配一个可用的 Token
     *
     * @param data   账号数据
     * @param device 此次登录的参数Model
     * @return 返回 Token
     */
    private String distUsableToken(AccountData data, String device) {
        boolean isConcurrent = getConfig().getIsConcurrent();
        // 如果配置为：不允许并发登录，则先将这个账号的历史登录标记为：被顶下线
        if (!isConcurrent) {
            replaced(data.getAccount(), device);
        }

        // 如果代码走到此处，说明未能成功复用旧Token，需要新建Token
        return JwtTokenHelper.generateToken(data);
    }

    /**
     * 顶人下线，根据账号id 和 设备类型
     * <p> 当对方再次访问系统时，会抛出NotLoginException异常，场景值=-4 </p>
     *
     * @param account 账号
     * @param device  设备类型 (填null代表顶替所有设备类型)
     */
    public void replaced(String account, String device) {
        SaSession session = getSessionByAccount(account, false);
        if (session == null) {
            return;
        }
        for (TokenSign tokenSign : session.getTokenSigns(device)) {
            // 清理： token签名、token最后活跃时间
            String token = tokenSign.getToken();
            session.removeTokenSign(token);
            clearLastActivity(token);
        }
    }

    /**
     * 获取指定账号id的User-Session, 如果Session尚未创建，isCreate=是否新建并返回
     *
     * @param account  账号
     * @param isCreate 是否新建
     * @return Session对象
     */
    public SaSession getSessionByAccount(String account, boolean isCreate) {
        SaSession session = getTokenDao().getSession(account);
        if (session == null && isCreate) {
            session = SaSession.create(account);
            getTokenDao().setSession(session, getConfig().getTimeout());
        }
        return session;
    }

    /**
     * 清除指定 Token 的 [最后操作时间记录]
     *
     * @param token 指定token
     */
    protected void clearLastActivity(String token) {
        // 如果token == null 或者 设置了[永不过期], 则立即返回
        if (token == null) {
            return;
        }
        // 删除[最后操作时间]
        getTokenDao().delete(token);
    }

    /**
     * 登录注销
     */
    public void logout() {
        PiscesRequest request = AppUtils.getBean(PiscesContext.class).getRequest();
        final String tokenHeader = "Authorization";
        final String tokenHead = "Bearer ";
        String authToken = request.getParam("token");
        String authHeader = request.getHeader(tokenHeader);
        if (!StringUtils.isEmpty(authHeader) && authHeader.startsWith(tokenHead)) {
            //如果header中存在token，则覆盖掉url中的token
            authToken = authHeader.substring(tokenHead.length());
        }

        if (!StringUtils.isEmpty(authToken)) {
//            String username = JwtTokenHelper.getUsernameFromToken(authToken);
//            // 登出后清除用户缓存信息
//            AppUtils.logout(username);
        }
    }
}
