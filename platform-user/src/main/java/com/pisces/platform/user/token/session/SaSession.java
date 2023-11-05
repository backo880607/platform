package com.pisces.platform.user.token.session;

import com.pisces.framework.core.utils.lang.DateUtils;
import com.pisces.framework.core.utils.lang.StringUtils;
import lombok.Getter;

import java.util.*;

/**
 * sa会话
 *
 * @author jason
 * @date 2023/07/24
 */
@Getter
public class SaSession {
    /**
     * 此 Session 的账号
     */
    private String account;

    /**
     * 此 Session 的创建时间（时间戳）
     */
    private Date createTime;

    /**
     * 此 Session 绑定的 Token 签名列表
     */
    private List<TokenSign> tokenSignList = new Vector<>();

    public static SaSession create(String account) {
        SaSession session = new SaSession();
        session.account = account;
        session.createTime = DateUtils.nowTime();
        return session;
    }

    /**
     * 更新Session（从持久库更新刷新一下）
     */
    public void update() {
//        SaManager.getSaTokenDao().updateSession(this);
    }

    /**
     * 获取 Token 签名列表 的拷贝副本
     *
     * @return token签名列表
     */
    private List<TokenSign> copyTokenSign() {
        return new ArrayList<>(tokenSignList);
    }

    public List<TokenSign> getTokenSigns(String device) {
        List<TokenSign> tokenSigns = copyTokenSign();
        if (StringUtils.isNotEmpty(device)) {
            tokenSigns.removeIf(tokenSign -> !Objects.equals(tokenSign.getDevice(), device));
        }
        return tokenSigns;
    }

    /**
     * 查找一个 Token 签名
     *
     * @param token token值
     * @return 查找到的 TokenSign
     */
    public TokenSign getTokenSign(String token) {
        for (TokenSign tokenSign : copyTokenSign()) {
            if (Objects.equals(tokenSign.getToken(), token)) {
                return tokenSign;
            }
        }
        return null;
    }

    /**
     * 添加一个 Token 签名
     *
     * @param tokenSign Token 签名
     */
    public void addTokenSign(TokenSign tokenSign) {
        // 如果已经存在于列表中，则无需再次添加
        if (getTokenSign(tokenSign.getToken()) != null) {
            return;
        }
        // 添加并更新
        tokenSignList.add(tokenSign);
        update();
    }

    /**
     * 移除一个 Token 签名
     *
     * @param token token值
     */
    public void removeTokenSign(String token) {
        TokenSign tokenSign = getTokenSign(token);
        if (tokenSignList.remove(tokenSign)) {
            update();
        }
    }
}
