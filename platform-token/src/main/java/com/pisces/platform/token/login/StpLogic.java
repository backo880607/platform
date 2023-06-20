package com.pisces.platform.token.login;

import com.pisces.framework.core.utils.lang.StringUtils;
import com.pisces.platform.token.SaManager;
import com.pisces.platform.token.config.TokenConstant;
import com.pisces.platform.token.config.TokenProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Sa-Token 权限认证，逻辑实现类 
 * @author kong
 */
public class StpLogic {

	/**
	 * 账号类型，多账号体系时以此值区分，比如：login、user、admin 
	 */
	public String loginType;
	
	/**
	 * 初始化StpLogic, 并指定账号类型 
	 * @param loginType 账号体系标识 
	 */
	public StpLogic(String loginType) {
		this.loginType = loginType;
		// 在 SaTokenManager 中记录下此 StpLogic，以便根据 LoginType 进行查找此对象 
//		SaManager.putStpLogic(this);
	}

	/**
	 * 获取当前 StpLogic 的账号类型
	 * @return See Note 
	 */
	public String getLoginType(){
		return loginType;
	}

	/**
	 * 设置当前账号类型
	 * @param loginType loginType
	 * @return 对象自身
	 */
	public StpLogic setLoginType(String loginType){
		this.loginType = loginType;
//		SaManager.putStpLogic(this);
		return this;
	}
	
	
	// ------------------- 获取token 相关 -------------------  
	
	/**
	 * 返回token名称 
	 * @return 此StpLogic的token名称
	 */
	public String getTokenName() {
 		return splicingKeyTokenName();
 	}

	/**
	 * 创建一个TokenValue
	 * @param loginId loginId
	 * @param device 设备类型
	 * @param timeout 过期时间
	 * @param extraData 扩展信息
	 * @return 生成的tokenValue
	 */
	public String createTokenValue(Object loginId, String device, long timeout, Map<String, Object> extraData) {
		return "";
//		return SaStrategy.me.createToken.apply(loginId, loginType);
	}

 	/**
 	 * 在当前会话写入当前TokenValue 
 	 * @param tokenValue token值 
 	 */
	public void setTokenValue(String tokenValue){
		setTokenValue(tokenValue, getConfig().getTimeout());
	}
	
 	/**
 	 * 在当前会话写入当前TokenValue 
 	 * @param tokenValue token值 
 	 * @param cookieTimeout Cookie存活时间(秒)
 	 */
	public void setTokenValue(String tokenValue, int cookieTimeout){
		setTokenValue(tokenValue, new SaLoginModel(cookieTimeout));
	}

 	/**
 	 * 在当前会话写入当前TokenValue 
 	 * @param tokenValue token值 
 	 * @param loginModel 登录参数 
 	 */
	public void setTokenValue(String tokenValue, SaLoginModel loginModel){
		if(StringUtils.isEmpty(tokenValue)) {
			return;
		}
		
		// 1. 将 Token 保存到 [存储器] 里  
//		setTokenValueToStorage(tokenValue);
//
//		// 2. 将 Token 保存到 [Cookie] 里
//		if (getConfig().getIsReadCookie()) {
//			setTokenValueToCookie(tokenValue, loginModel.getCookieTimeout());
//		}
//
//		// 3. 将 Token 写入到响应头里
//		if(loginModel.getIsWriteHeaderOrGlobalConfig()) {
//			setTokenValueToResponseHeader(tokenValue);
//		}
	}
	
 	/**
 	 * 将 Token 保存到 [Cookie] 里 
 	 * @param tokenValue token值 
 	 * @param cookieTimeout Cookie存活时间(秒)
 	 */
//	public void setTokenValueToCookie(String tokenValue, int cookieTimeout){
//		SaCookieConfig cfg = getConfig().getCookie();
//		SaCookie cookie = new SaCookie()
//				.setName(getTokenName())
//				.setValue(tokenValue)
//				.setMaxAge(cookieTimeout)
//				.setDomain(cfg.getDomain())
//				.setPath(cfg.getPath())
//				.setSecure(cfg.getSecure())
//				.setHttpOnly(cfg.getHttpOnly())
//				.setSameSite(cfg.getSameSite())
//				;
//		SaHolder.getResponse().addCookie(cookie);
//	}

 	/**
 	 * 将 Token 写入到 [响应头] 里 
 	 * @param tokenValue token值 
 	 */
//	public void setTokenValueToResponseHeader(String tokenValue){
//		String tokenName = getTokenName();
//		SaResponse response = SaHolder.getResponse();
//		response.setHeader(tokenName, tokenValue);
//		response.addHeader(SaResponse.ACCESS_CONTROL_EXPOSE_HEADERS, tokenName);
//	}
 	
	/**
	 * 获取当前TokenValue
	 * @return 当前tokenValue
	 */
	public String getTokenValue(){
		// 1. 获取
		String tokenValue = "";//getTokenValueNotCut();

		// 3. 返回
		return tokenValue;
	}
	
	/**
	 * 获取当前会话的Token信息 
	 * @return token信息 
	 */
	public SaTokenInfo getTokenInfo() {
		SaTokenInfo info = new SaTokenInfo();
		info.tokenName = getTokenName();
		info.tokenValue = "";//getTokenValue();
		info.isLogin = isLogin();
		info.loginId = getLoginIdDefaultNull();
		info.loginType = getLoginType();
		info.tokenTimeout = getTokenTimeout();
		info.sessionTimeout = getSessionTimeout();
		info.tokenSessionTimeout = getTokenSessionTimeout();
		info.tokenActivityTimeout = getTokenActivityTimeout();
		info.loginDevice = getLoginDevice();
		return info;
	}
	
	
	// ------------------- 登录相关操作 -------------------  

	// --- 登录 
	
	/**
	 * 会话登录 
	 * @param id 账号id，建议的类型：（long | int | String）
	 */
	public void login(Object id) {
		login(id, new SaLoginModel());
	}

	/**
	 * 会话登录，并指定登录设备类型
	 * @param id 账号id，建议的类型：（long | int | String）
	 * @param device 设备类型 
	 */
	public void login(Object id, String device) {
		login(id, new SaLoginModel(device));
	}

	/**
	 * 会话登录，并指定是否 [记住我] 
	 * @param id 账号id，建议的类型：（long | int | String）
	 * @param isLastingCookie 是否为持久Cookie 
	 */
	public void login(Object id, boolean isLastingCookie) {
		SaLoginModel model = new SaLoginModel();
		model.setIsLastingCookie(isLastingCookie);
		login(id, model);
	}

	/**
	 * 会话登录，并指定此次登录token的有效期, 单位:秒
	 *
	 * @param id      账号id，建议的类型：（long | int | String）
	 * @param timeout 此次登录token的有效期, 单位:秒
	 */
	public void login(Object id, int timeout) {
		login(id, new SaLoginModel(timeout));
	}

	/**
	 * 会话登录，并指定所有登录参数Model 
	 * @param id 登录id，建议的类型：（long | int | String）
	 * @param loginModel 此次登录的参数Model 
	 */
	public void login(Object id, SaLoginModel loginModel) {
		// 1、创建会话 
		String token = "";//createLoginSession(id, loginModel);

		// 2、在当前客户端注入Token 
		setTokenValue(token, loginModel);
	}
	
	// --- 注销 
	
	/** 
	 * 会话注销 
	 */
	public void logout() {
//		// 如果连 Token 都没有，那么无需执行任何操作
//		String tokenValue = getTokenValue();
// 		if(StringUtils.isEmpty(tokenValue)) {
// 			return;
// 		}
//
// 		// 如果打开了 Cookie 模式，则把 Cookie 清除掉
// 		if(getConfig().getIsReadCookie()){
// 			SaCookieConfig cookie = getConfig().getCookie();
// 			SaHolder.getResponse().deleteCookie(getTokenName(), cookie.getPath(), cookie.getDomain());
//		}
//
// 		// 从当前 [Storage存储器] 里删除 Token
// 		SaHolder.getStorage().delete(splicingKeyJustCreatedSave());
//
// 		// 清除当前上下文的 [临时有效期check标记]
// 	 	SaHolder.getStorage().delete(TokenConstant.TOKEN_ACTIVITY_TIMEOUT_CHECKED_KEY);
//
// 		// 清除这个 Token 的相关信息
// 		logoutByTokenValue(tokenValue);
	}

	/**
	 * 会话注销，根据账号id 
	 * 
	 * @param loginId 账号id 
	 */
	public void logout(Object loginId) {
		logout(loginId, null);
	}

	/**
	 * 会话注销，根据账号id 和 设备类型
	 * 
	 * @param loginId 账号id 
	 * @param device 设备类型 (填null代表注销所有设备类型) 
	 */
	public void logout(Object loginId, String device) {
//		SaSession session = getSessionByLoginId(loginId, false);
//		if(session != null) {
//			for (TokenSign tokenSign: session.tokenSignListCopyByDevice(device)) {
//				// 清理： token签名、token最后活跃时间
//				String tokenValue = tokenSign.getValue();
//				session.removeTokenSign(tokenValue);
//				clearLastActivity(tokenValue);
//		 		// 删除Token-Id映射 & 清除Token-Session
//				deleteTokenToIdMapping(tokenValue);
//				deleteTokenSession(tokenValue);
//				// $$ 发布事件：指定账号注销
//				SaTokenEventCenter.doLogout(loginType, loginId, tokenValue);
//			}
//			// 注销 Session
//			session.logoutByTokenSignCountToZero();
//		}
	}
	
	// ---- 会话查询 
	
 	/** 
 	 * 当前会话是否已经登录 
 	 * @return 是否已登录 
 	 */
 	public boolean isLogin() {
 		// 判断条件：不为null，并且不在异常项集合里 
 		return getLoginIdDefaultNull() != null;
 	}

	/**
	 * 获取当前会话账号id, 如果未登录，则抛出异常
	 * @return 账号id
	 */
	public Object getLoginId() {
		return null;
	}
 	
 	/** 
 	 * 检验当前会话是否已经登录，如未登录，则抛出异常 
 	 */
 	public void checkLogin() {
 		getLoginId();
 	}
	
 	/** 
	 * 获取当前会话账号id, 如果未登录，则返回默认值 
	 * @param <T> 返回类型 
	 * @param defaultValue 默认值
	 * @return 登录id 
	 */
 	@SuppressWarnings("unchecked")
	public <T>T getLoginId(T defaultValue) {
		Object loginId = getLoginIdDefaultNull();
		// 如果loginId为null，则返回默认值 
		if(loginId == null) {
			return defaultValue;
		}
		// 开始尝试类型转换，只尝试三种类型：int、long、String 
		if(defaultValue instanceof Integer) {
			return (T)Integer.valueOf(loginId.toString());
		}
		if(defaultValue instanceof Long) {
			return (T)Long.valueOf(loginId.toString());
		}
		if(defaultValue instanceof String) {
			return (T)loginId.toString();
		}
		return (T)loginId;
 	}

	/**
	 * 获取当前会话账号id, 如果未登录，则返回null
	 * @return 账号id
	 */
	public Object getLoginIdDefaultNull() {
		// 如果正在[临时身份切换]
//		if(isSwitch()) {
//			return getSwitchLoginId();
//		}
		// 如果连token都是空的，则直接返回
		String tokenValue = "";//getTokenValue();
		if(tokenValue == null) {
			return null;
		}
		// loginId为null或者在异常项里面，均视为未登录, 返回null
		Object loginId = getLoginIdNotHandle(tokenValue);
		if(isValidLoginId(loginId) == false) {
			return null;
		}
		// 如果已经[临时过期]
		if(getTokenActivityTimeoutByToken(tokenValue) == TokenConstant.NOT_VALUE_EXPIRE) {
			return null;
		}
		// 执行到此，证明loginId已经是个正常的账号id了
		return loginId;
	}

	/** 
	 * 获取当前会话账号id, 并转换为String类型
	 * @return 账号id 
	 */
 	public String getLoginIdAsString() {
 		return String.valueOf(getLoginId());
 	}

 	/** 
	 * 获取当前会话账号id, 并转换为int类型
	 * @return 账号id 
	 */
 	public int getLoginIdAsInt() {
 		return Integer.parseInt(String.valueOf(getLoginId()));
 	}

 	/**
	 * 获取当前会话账号id, 并转换为long类型 
	 * @return 账号id 
	 */
 	public long getLoginIdAsLong() {
 		return Long.parseLong(String.valueOf(getLoginId()));
 	}
 	
 	/** 
 	 * 获取指定Token对应的账号id，如果未登录，则返回 null 
 	 * @param tokenValue token
 	 * @return 账号id
 	 */
 	public Object getLoginIdByToken(String tokenValue) {
 		// token为空时，直接返回null 
 		if(StringUtils.isEmpty(tokenValue)) {
 	 		return null;
 		}
 		// loginId为无效值时，直接返回null 
 		String loginId = getLoginIdNotHandle(tokenValue);
 		if(isValidLoginId(loginId) == false) {
 			return null;
 		}
 		// 
 		return loginId;
 	}

 	 /**
 	  * 获取指定Token对应的账号id (不做任何特殊处理) 
 	  * @param tokenValue token值 
 	  * @return 账号id
 	  */
 	public String getLoginIdNotHandle(String tokenValue) {
 		return getSaTokenDao().get(splicingKeyTokenValue(tokenValue));
 	}

 	
	// ---- 其它操作 
 	/**
	 * 判断一个 loginId 是否是有效的 
	 * @param loginId 账号id 
	 * @return / 
	 */
	public boolean isValidLoginId(Object loginId) {
		return loginId != null ;// && !NotLoginException.ABNORMAL_LIST.contains(loginId.toString());
	}
	/**
	 * 删除 Token-Id 映射 
	 * @param tokenValue token值 
	 */
	public void deleteTokenToIdMapping(String tokenValue) {
		getSaTokenDao().delete(splicingKeyTokenValue(tokenValue));
	}
	/**
	 * 更改 Token 指向的 账号Id 值 
	 * @param tokenValue token值 
	 * @param loginId 新的账号Id值
	 */
	public void updateTokenToIdMapping(String tokenValue, Object loginId) {
//		SaTokenException.throwBy(StringUtils.isEmpty(loginId), "LoginId 不能为空", SaErrorCode.CODE_11003);
		getSaTokenDao().update(splicingKeyTokenValue(tokenValue), loginId.toString());
	}
	/**
	 * 存储 Token-Id 映射 
	 * @param tokenValue token值 
	 * @param loginId 账号id 
	 * @param timeout 会话有效期 (单位: 秒) 
	 */
	public void saveTokenToIdMapping(String tokenValue, Object loginId, long timeout) {
		getSaTokenDao().set(splicingKeyTokenValue(tokenValue), String.valueOf(loginId), timeout);
	}
 	
	// ------------------- [临时有效期] 验证相关 -------------------  

	/**
 	 * 写入指定token的 [最后操作时间] 为当前时间戳 
 	 * @param tokenValue 指定token 
 	 */
 	protected void setLastActivityToNow(String tokenValue) {
 		// 如果token == null 或者 设置了[永不过期], 则立即返回 
 		if(tokenValue == null || isOpenActivityCheck() == false) {
 			return;
 		}
 		// 将[最后操作时间]标记为当前时间戳 
 		getSaTokenDao().set(splicingKeyLastActivityTime(tokenValue), String.valueOf(System.currentTimeMillis()), getConfig().getTimeout());
 	}
 	
 	/**
 	 * 清除指定 Token 的 [最后操作时间记录]
 	 * @param tokenValue 指定token 
 	 */
 	protected void clearLastActivity(String tokenValue) {
 		// 如果token == null 或者 设置了[永不过期], 则立即返回 
 		if(tokenValue == null || isOpenActivityCheck() == false) {
 			return;
 		}
 		// 删除[最后操作时间]
 		getSaTokenDao().delete(splicingKeyLastActivityTime(tokenValue));
 	}
 	
 	/**
 	 * 检查指定token 是否已经[临时过期]，如果已经过期则抛出异常  
 	 * @param tokenValue 指定token
 	 */
 	public void checkActivityTimeout(String tokenValue) {
 		// 如果token == null 或者 设置了[永不过期], 则立即返回 
 		if(tokenValue == null || isOpenActivityCheck() == false) {
 			return;
 		}
// 		// 如果本次请求已经有了[检查标记], 则立即返回
// 		SaStorage storage = SaHolder.getStorage();
// 		if(storage.get(TokenConstant.TOKEN_ACTIVITY_TIMEOUT_CHECKED_KEY) != null) {
// 			return;
// 		}
// 		// ------------ 验证是否已经 [临时过期]
// 		// 获取 [临时剩余时间]
// 		long timeout = getTokenActivityTimeoutByToken(tokenValue);
// 		// -1 代表此token已经被设置永不过期，无须继续验证
// 		if(timeout == SaTokenDao.NEVER_EXPIRE) {
// 			return;
// 		}
// 		// -2 代表已过期，抛出异常
// 		if(timeout == SaTokenDao.NOT_VALUE_EXPIRE) {
// 			throw NotLoginException.newInstance(loginType, NotLoginException.TOKEN_TIMEOUT, tokenValue).setCode(SaErrorCode.CODE_11016);
// 		}
// 		// --- 至此，验证已通过
//
// 		// 打上[检查标记]，标记一下当前请求已经通过验证，避免一次请求多次验证，造成不必要的性能消耗
// 		storage.set(TokenConstant.TOKEN_ACTIVITY_TIMEOUT_CHECKED_KEY, true);
 	}

 	/**
 	 * 检查当前token 是否已经[临时过期]，如果已经过期则抛出异常  
 	 */
 	public void checkActivityTimeout() {
 		checkActivityTimeout(getTokenValue());
 	}
 	
 	/**
 	 * 续签指定token：(将 [最后操作时间] 更新为当前时间戳) 
 	 * @param tokenValue 指定token 
 	 */
 	public void updateLastActivityToNow(String tokenValue) {
 		// 如果token == null 或者 设置了[永不过期], 则立即返回 
 		if(tokenValue == null || isOpenActivityCheck() == false) {
 			return;
 		}
 		getSaTokenDao().update(splicingKeyLastActivityTime(tokenValue), String.valueOf(System.currentTimeMillis()));
 	}

 	/**
 	 * 续签当前token：(将 [最后操作时间] 更新为当前时间戳) 
 	 * <h1>请注意: 即使token已经 [临时过期] 也可续签成功，
 	 * 如果此场景下需要提示续签失败，可在此之前调用 checkActivityTimeout() 强制检查是否过期即可 </h1>
 	 */
 	public void updateLastActivityToNow() {
 		updateLastActivityToNow(getTokenValue());
 	}
 	
	// ------------------- 过期时间相关 -------------------  

 	/**
 	 * 获取当前登录者的 token 剩余有效时间 (单位: 秒)
 	 * @return token剩余有效时间
 	 */
 	public long getTokenTimeout() {
 		return getSaTokenDao().getTimeout(splicingKeyTokenValue(getTokenValue()));
 	}
 	
 	/**
 	 * 获取指定 loginId 的 token 剩余有效时间 (单位: 秒) 
 	 * @param loginId 指定loginId 
 	 * @return token剩余有效时间 
 	 */
 	public long getTokenTimeoutByLoginId(Object loginId) {
 		return getSaTokenDao().getTimeout(splicingKeyTokenValue(getTokenValueByLoginId(loginId)));
 	}

 	/**
 	 * 获取当前登录者的 User-Session 剩余有效时间 (单位: 秒)
 	 * @return token剩余有效时间
 	 */
 	public long getSessionTimeout() {
 		return getSessionTimeoutByLoginId(getLoginIdDefaultNull());
 	}
 	
 	/**
 	 * 获取指定 loginId 的 User-Session 剩余有效时间 (单位: 秒) 
 	 * @param loginId 指定loginId 
 	 * @return token剩余有效时间 
 	 */
 	public long getSessionTimeoutByLoginId(Object loginId) {
 		return getSaTokenDao().getSessionTimeout(splicingKeySession(loginId));
 	}

 	/**
 	 * 获取当前 Token-Session 剩余有效时间 (单位: 秒) 
 	 * @return token剩余有效时间
 	 */
 	public long getTokenSessionTimeout() {
 		return getTokenSessionTimeoutByTokenValue(getTokenValue());
 	}
 	
 	/**
 	 * 获取指定 Token-Session 剩余有效时间 (单位: 秒) 
 	 * @param tokenValue 指定token 
 	 * @return token剩余有效时间 
 	 */
 	public long getTokenSessionTimeoutByTokenValue(String tokenValue) {
 		return getSaTokenDao().getSessionTimeout(splicingKeyTokenSession(tokenValue));
 	}

 	/**
 	 * 获取当前 token [临时过期] 剩余有效时间 (单位: 秒)
 	 * @return token [临时过期] 剩余有效时间
 	 */
 	public long getTokenActivityTimeout() {
 		return getTokenActivityTimeoutByToken(getTokenValue());
 	}
 	
 	/**
 	 * 获取指定 token [临时过期] 剩余有效时间 (单位: 秒)
 	 * @param tokenValue 指定token 
 	 * @return token[临时过期]剩余有效时间
 	 */
 	public long getTokenActivityTimeoutByToken(String tokenValue) {
 		// 如果token为null , 则返回 -2
 		if(tokenValue == null) {
 			return SaTokenDao.NOT_VALUE_EXPIRE;
 		}
 		// 如果设置了永不过期, 则返回 -1 
 		if(isOpenActivityCheck() == false) {
 			return SaTokenDao.NEVER_EXPIRE;
 		}
 		// ------ 开始查询 
 		// 获取相关数据 
 		String keyLastActivityTime = splicingKeyLastActivityTime(tokenValue);
 		String lastActivityTimeString = getSaTokenDao().get(keyLastActivityTime);
 		// 查不到，返回-2 
 		if(lastActivityTimeString == null) {
 			return SaTokenDao.NOT_VALUE_EXPIRE;
 		}
 		// 计算相差时间
 		long lastActivityTime = Long.parseLong(lastActivityTimeString);
 		long apartSecond = (System.currentTimeMillis() - lastActivityTime) / 1000;
 		long timeout = getConfig().getActivityTimeout() - apartSecond;
 		// 如果 < 0， 代表已经过期 ，返回-2 
 		if(timeout < 0) {
 			return SaTokenDao.NOT_VALUE_EXPIRE;
 		}
 		return timeout;
 	}

 	/**
 	 * 对当前 Token 的 timeout 值进行续期 
 	 * @param timeout 要修改成为的有效时间 (单位: 秒) 
 	 */
 	public void renewTimeout(long timeout) {
 		// 续期 db 数据 
 		String tokenValue = getTokenValue();
 		renewTimeout(tokenValue, timeout);
 		
 		// 续期客户端Cookie有效期 
// 		if(getConfig().getIsReadCookie()) {
// 			setTokenValueToCookie(tokenValue, (int)timeout);
// 		}
 	}
 	
 	/**
 	 * 对指定 Token 的 timeout 值进行续期 
 	 * @param tokenValue 指定token 
 	 * @param timeout 要修改成为的有效时间 (单位: 秒) 
 	 */
 	public void renewTimeout(String tokenValue, long timeout) {
 		
 		// Token 指向的 LoginId 异常时，不进行任何操作 
 		Object loginId = getLoginIdByToken(tokenValue);
 		if(loginId == null) {
 			return;
 		}
 		
 		SaTokenDao dao = getSaTokenDao();
 		
 		// 续期 Token 有效期 
 		dao.updateTimeout(splicingKeyTokenValue(tokenValue), timeout);

// 		// 续期 Token-Session 有效期
//		SaSession tokenSession = getTokenSessionByToken(tokenValue, false);
//		if(tokenSession != null) {
//			tokenSession.updateTimeout(timeout);
//		}
//
// 		// 续期指向的 User-Session 有效期
// 		getSessionByLoginId(loginId).updateMinTimeout(timeout);
//
// 		// Token-Activity 活跃检查相关
// 		if(isOpenActivityCheck()) {
// 			dao.updateTimeout(splicingKeyLastActivityTime(tokenValue), timeout);
// 		}
//
//		// 通知更新超时事件
//		SaTokenEventCenter.doRenewTimeout(tokenValue, loginId, timeout);
 	}
 	
	
	// ------------------- id 反查 token 相关操作 -------------------  
	
	/** 
	 * 获取指定账号id的tokenValue 
	 * <p> 在配置为允许并发登录时，此方法只会返回队列的最后一个token，
	 * 如果你需要返回此账号id的所有token，请调用 getTokenValueListByLoginId 
	 * @param loginId 账号id
	 * @return token值 
	 */
	public String getTokenValueByLoginId(Object loginId) {
		return getTokenValueByLoginId(loginId, null);
	}

	/** 
	 * 获取指定账号id指定设备类型端的tokenValue 
	 * <p> 在配置为允许并发登录时，此方法只会返回队列的最后一个token，
	 * 如果你需要返回此账号id的所有token，请调用 getTokenValueListByLoginId 
	 * @param loginId 账号id
	 * @param device 设备类型，填null代表不限设备类型 
	 * @return token值 
	 */
	public String getTokenValueByLoginId(Object loginId, String device) {
		List<String> tokenValueList = getTokenValueListByLoginId(loginId, device);
		return tokenValueList.size() == 0 ? null : tokenValueList.get(tokenValueList.size() - 1);
	}
	
 	/** 
	 * 获取指定账号id的tokenValue集合 
	 * @param loginId 账号id 
	 * @return 此loginId的所有相关token 
 	 */
	public List<String> getTokenValueListByLoginId(Object loginId) {
		return getTokenValueListByLoginId(loginId, null);
	}

 	/** 
	 * 获取指定账号id指定设备类型端的tokenValue 集合 
	 * @param loginId 账号id 
	 * @param device 设备类型，填null代表不限设备类型
	 * @return 此loginId的所有相关token 
 	 */
	public List<String> getTokenValueListByLoginId(Object loginId, String device) {
		List<String> tokenValueList = new ArrayList<>();
		// 如果session为null的话直接返回空集合  
//		SaSession session = getSessionByLoginId(loginId, false);
//		if(session == null) {
//			return tokenValueList;
//		}
//		// 遍历解析
//		List<TokenSign> tokenSignList = session.tokenSignListCopy();
//		for (TokenSign tokenSign : tokenSignList) {
//			if(device == null || tokenSign.getDevice().equals(device)) {
//				tokenValueList.add(tokenSign.getValue());
//			}
//		}
		return tokenValueList;
	}
	
	/**
	 * 返回当前会话的登录设备类型
	 * @return 当前令牌的登录设备类型
	 */
	public String getLoginDevice() {
		// 如果没有token，直接返回 null 
		String tokenValue = getTokenValue();
		if(tokenValue == null) {
			return null;
		}
		// 如果还未登录，直接返回 null 
		if(!isLogin()) {
			return null;
		}
//		// 如果session为null的话直接返回 null
//		SaSession session = getSessionByLoginId(getLoginIdDefaultNull(), false);
//		if(session == null) {
//			return null;
//		}
//		// 遍历解析
//		List<TokenSign> tokenSignList = session.tokenSignListCopy();
//		for (TokenSign tokenSign : tokenSignList) {
//			if(tokenSign.getValue().equals(tokenValue)) {
//				return tokenSign.getDevice();
//			}
//		}
		return null;
	}
	

	// ------------------- 会话管理 -------------------  

	/**
	 * 根据条件查询Token 
	 * @param keyword 关键字 
	 * @param start 开始处索引
	 * @param size 获取数量 (-1代表一直获取到末尾) 
	 * @param sortType 排序类型（true=正序，false=反序）
	 *
	 * @return token集合
	 */
	public List<String> searchTokenValue(String keyword, int start, int size, boolean sortType) {
		return getSaTokenDao().searchData(splicingKeyTokenValue(""), keyword, start, size, sortType);
	}
	
	/**
	 * 根据条件查询SessionId 
	 * @param keyword 关键字 
	 * @param start 开始处索引 
	 * @param size 获取数量  (-1代表一直获取到末尾) 
	 * @param sortType 排序类型（true=正序，false=反序）
	 *
	 * @return sessionId集合
	 */
	public List<String> searchSessionId(String keyword, int start, int size, boolean sortType) {
		return getSaTokenDao().searchData(splicingKeySession(""), keyword, start, size, sortType);
	}

	/**
	 * 根据条件查询Token专属Session的Id 
	 * @param keyword 关键字 
	 * @param start 开始处索引 
	 * @param size 获取数量 (-1代表一直获取到末尾) 
	 * @param sortType 排序类型（true=正序，false=反序）
	 *
	 * @return sessionId集合
	 */
	public List<String> searchTokenSessionId(String keyword, int start, int size, boolean sortType) {
		return getSaTokenDao().searchData(splicingKeyTokenSession(""), keyword, start, size, sortType);
	}
	
	
	// ------------------- 账号封禁 -------------------  

	/**
	 * 封禁：指定账号
	 * <p> 此方法不会直接将此账号id踢下线，如需封禁后立即掉线，请追加调用 StpUtil.logout(id)
	 * 
	 * @param loginId 指定账号id 
	 * @param time 封禁时间, 单位: 秒 （-1=永久封禁）
	 */
	public void disable(Object loginId, long time) {
		disableLevel(loginId, TokenConstant.DEFAULT_DISABLE_SERVICE, TokenConstant.DEFAULT_DISABLE_LEVEL, time);
	}

	/**
	 * 判断：指定账号是否已被封禁 (true=已被封禁, false=未被封禁) 
	 * 
	 * @param loginId 账号id
	 * @return / 
	 */
	public boolean isDisable(Object loginId) {
		return isDisableLevel(loginId, TokenConstant.DEFAULT_DISABLE_SERVICE, TokenConstant.MIN_DISABLE_LEVEL);
	}

	/**
	 * 校验：指定账号是否已被封禁，如果被封禁则抛出异常 
	 * @param loginId 账号id
	 */
	public void checkDisable(Object loginId) {
		checkDisableLevel(loginId, TokenConstant.DEFAULT_DISABLE_SERVICE, TokenConstant.MIN_DISABLE_LEVEL);
	}
	
	/**
	 * 获取：指定账号剩余封禁时间，单位：秒（-1=永久封禁，-2=未被封禁）
	 * @param loginId 账号id
	 * @return / 
	 */
	public long getDisableTime(Object loginId) {
		return getDisableTime(loginId, TokenConstant.DEFAULT_DISABLE_SERVICE);
	}

	/**
	 * 解封：指定账号
	 * @param loginId 账号id
	 */
	public void untieDisable(Object loginId) {
		untieDisable(loginId, TokenConstant.DEFAULT_DISABLE_SERVICE);
	}
	
	
	// ------------------- 分类封禁 -------------------  

	/**
	 * 封禁：指定账号的指定服务 
	 * <p> 此方法不会直接将此账号id踢下线，如需封禁后立即掉线，请追加调用 StpUtil.logout(id)
	 * @param loginId 指定账号id 
	 * @param service 指定服务 
	 * @param time 封禁时间, 单位: 秒 （-1=永久封禁）
	 */
	public void disable(Object loginId, String service, long time) {
		disableLevel(loginId, service, TokenConstant.DEFAULT_DISABLE_LEVEL, time);
	}

	/**
	 * 判断：指定账号的指定服务 是否已被封禁 (true=已被封禁, false=未被封禁) 
	 * @param loginId 账号id
	 * @param service 指定服务 
	 * @return / 
	 */
	public boolean isDisable(Object loginId, String service) {
		return isDisableLevel(loginId, service, TokenConstant.MIN_DISABLE_LEVEL);
	}

	/**
	 * 校验：指定账号 指定服务 是否已被封禁，如果被封禁则抛出异常 
	 * @param loginId 账号id
	 * @param services 指定服务，可以指定多个 
	 */
	public void checkDisable(Object loginId, String... services) {
		if(services != null) {
			for (String service : services) {
				checkDisableLevel(loginId, service, TokenConstant.MIN_DISABLE_LEVEL);
			}
		}
	}

	/**
	 * 获取：指定账号 指定服务 剩余封禁时间，单位：秒（-1=永久封禁，-2=未被封禁）
	 * @param loginId 账号id
	 * @param service 指定服务 
	 * @return see note 
	 */
	public long getDisableTime(Object loginId, String service) {
		return getSaTokenDao().getTimeout(splicingKeyDisable(loginId, service));
	}

	/**
	 * 解封：指定账号、指定服务
	 * @param loginId 账号id
	 * @param services 指定服务，可以指定多个 
	 */
	public void untieDisable(Object loginId, String... services) {
		// 空值检查 
//		if(StringUtils.isEmpty(loginId)) {
//			throw new SaTokenException("请提供要解禁的账号").setCode(SaErrorCode.CODE_11062);
//		}
//		if(services == null || services.length == 0) {
//			throw new SaTokenException("请提供要解禁的服务").setCode(SaErrorCode.CODE_11063);
//		}
				
		for (String service : services) {
			// 解封 
			getSaTokenDao().delete(splicingKeyDisable(loginId, service));
			
	 		// $$ 发布事件 
//			SaTokenEventCenter.doUntieDisable(loginType, loginId, service);
		}
	}

	
	// ------------------- 阶梯封禁 -------------------  

	/**
	 * 封禁：指定账号，并指定封禁等级 
	 * @param loginId 指定账号id 
	 * @param level 指定封禁等级 
	 * @param time 封禁时间, 单位: 秒 （-1=永久封禁）
	 */
	public void disableLevel(Object loginId, int level, long time) {
		disableLevel(loginId, TokenConstant.DEFAULT_DISABLE_SERVICE, level, time);
	}

	/**
	 * 封禁：指定账号的指定服务，并指定封禁等级 
	 * @param loginId 指定账号id 
	 * @param service 指定封禁服务 
	 * @param level 指定封禁等级 
	 * @param time 封禁时间, 单位: 秒 （-1=永久封禁）
	 */
	public void disableLevel(Object loginId, String service, int level, long time) {
		// 空值检查 
//		if(StringUtils.isEmpty(loginId)) {
//			throw new SaTokenException("请提供要封禁的账号").setCode(SaErrorCode.CODE_11062);
//		}
//		if(StringUtils.isEmpty(service)) {
//			throw new SaTokenException("请提供要封禁的服务").setCode(SaErrorCode.CODE_11063);
//		}
//		if(level < TokenConstant.MIN_DISABLE_LEVEL) {
//			throw new SaTokenException("封禁等级不可以小于最小值：" + TokenConstant.MIN_DISABLE_LEVEL).setCode(SaErrorCode.CODE_11064);
//		}

		// 标注为已被封禁
		getSaTokenDao().set(splicingKeyDisable(loginId, service), String.valueOf(level), time);
 		
 		// $$ 发布事件 
//		SaTokenEventCenter.doDisable(loginType, loginId, service, level, time);
	}

	/**
	 * 判断：指定账号是否已被封禁到指定等级
	 * 
	 * @param loginId 指定账号id 
	 * @param level 指定封禁等级 
	 * @return / 
	 */
	public boolean isDisableLevel(Object loginId, int level) {
		return isDisableLevel(loginId, TokenConstant.DEFAULT_DISABLE_SERVICE, level);
	}

	/**
	 * 判断：指定账号的指定服务，是否已被封禁到指定等级 
	 * 
	 * @param loginId 指定账号id 
	 * @param service 指定封禁服务 
	 * @param level 指定封禁等级 
	 * @return / 
	 */
	public boolean isDisableLevel(Object loginId, String service, int level) {
		// s1. 检查是否被封禁 
		int disableLevel = getDisableLevel(loginId, service);
		if(disableLevel == TokenConstant.NOT_DISABLE_LEVEL) {
			return false;
		}
		// s2. 检测被封禁的等级是否达到指定级别 
		return disableLevel >= level;
	}

	/**
	 * 校验：指定账号是否已被封禁到指定等级（如果已经达到，则抛出异常）
	 * 
	 * @param loginId 指定账号id 
	 * @param level 封禁等级 （只有 封禁等级 ≥ 此值 才会抛出异常）
	 */
	public void checkDisableLevel(Object loginId, int level) {
		checkDisableLevel(loginId, TokenConstant.DEFAULT_DISABLE_SERVICE, level);
	}

	/**
	 * 校验：指定账号的指定服务，是否已被封禁到指定等级（如果已经达到，则抛出异常）
	 * 
	 * @param loginId 指定账号id 
	 * @param service 指定封禁服务 
	 * @param level 封禁等级 （只有 封禁等级 ≥ 此值 才会抛出异常）
	 */
	public void checkDisableLevel(Object loginId, String service, int level) {
		// s1. 检查是否被封禁 
		String value = getSaTokenDao().get(splicingKeyDisable(loginId, service));
		if(StringUtils.isEmpty(value)) {
			return;
		}
		// s2. 检测被封禁的等级是否达到指定级别 
//		Integer disableLevel = SaFoxUtil.getValueByType(value, int.class);
//		if(disableLevel >= level) {
//			throw new DisableServiceException(loginType, loginId, service, disableLevel, level, getDisableTime(loginId, service)).setCode(SaErrorCode.CODE_11061);
//		}
	}

	/**
	 * 获取：指定账号被封禁的等级，如果未被封禁则返回-2 
	 * 
	 * @param loginId 指定账号id 
	 * @return / 
	 */
	public int getDisableLevel(Object loginId) {
		return getDisableLevel(loginId, TokenConstant.DEFAULT_DISABLE_SERVICE);
	}

	/**
	 * 获取：指定账号的 指定服务 被封禁的等级，如果未被封禁则返回-2 
	 * 
	 * @param loginId 指定账号id 
	 * @param service 指定封禁服务 
	 * @return / 
	 */
	public int getDisableLevel(Object loginId, String service) {
		// q1. 如果尚未被封禁，则返回-2 
		String value = getSaTokenDao().get(splicingKeyDisable(loginId, service));
		if(StringUtils.isEmpty(value)) {
			return TokenConstant.NOT_DISABLE_LEVEL;
		}
		return Integer.parseInt(value);
	}


	// ------------------- 二级认证 -------------------  
	
	/**
	 * 在当前会话 开启二级认证 
	 * @param safeTime 维持时间 (单位: 秒) 
	 */
	public void openSafe(long safeTime) {
		openSafe(TokenConstant.DEFAULT_SAFE_AUTH_SERVICE, safeTime);
	}

	/**
	 * 在当前会话 开启二级认证 
	 * @param service 业务标识  
	 * @param safeTime 维持时间 (单位: 秒) 
	 */
	public void openSafe(String service, long safeTime) {
		// 开启二级认证前必须处于登录状态 
		checkLogin();
		
		// 写入key 
//		String tokenValue = getTokenValueNotNull();
//		getSaTokenDao().set(splicingKeySafe(tokenValue, service), TokenConstant.SAFE_AUTH_SAVE_VALUE, safeTime);
//
//		// $$ 发布事件
//		SaTokenEventCenter.doOpenSafe(loginType, tokenValue, service, safeTime);
	}

	/**
	 * 当前会话 是否处于二级认证时间内 
	 * @return true=二级认证已通过, false=尚未进行二级认证或认证已超时 
	 */
	public boolean isSafe() {
		return isSafe(TokenConstant.DEFAULT_SAFE_AUTH_SERVICE);
	}

	/**
	 * 当前会话 是否处于二级认证时间内 
	 * @param service 业务标识  
	 * @return true=二级认证已通过, false=尚未进行二级认证或认证已超时 
	 */
	public boolean isSafe(String service) {
		return isSafe(getTokenValue(), service);
	}

	/**
	 * 指定 Token 是否处于二级认证时间内 
	 * @param tokenValue Token 值  
	 * @param service 业务标识  
	 * @return true=二级认证已通过, false=尚未进行二级认证或认证已超时 
	 */
	public boolean isSafe(String tokenValue, String service) {
		// 如果 Token 为空，则直接视为未认证  
		if(StringUtils.isEmpty(tokenValue)) {
			return false;
		}
		
		// 如果DB中可以查询出指定的键值，则代表已认证，否则视为未认证 
		String value = getSaTokenDao().get(splicingKeySafe(tokenValue, service));
		return StringUtils.isNotEmpty(value);
	}

	/**
	 * 检查当前会话是否已通过二级认证，如未通过则抛出异常 
	 */
	public void checkSafe() {
		checkSafe(TokenConstant.DEFAULT_SAFE_AUTH_SERVICE);
	}

	/**
	 * 检查当前会话是否已通过二级认证，如未通过则抛出异常 
	 * @param service 业务标识  
	 */
	public void checkSafe(String service) {
		String tokenValue = getTokenValue();
//		if (isSafe(tokenValue, service) == false) {
//			throw new NotSafeException(loginType, tokenValue, service).setCode(SaErrorCode.CODE_11071);
//		}
	}
	
	/**
	 * 获取当前会话的二级认证剩余有效时间 (单位: 秒, 返回-2代表尚未通过二级认证)
	 * @return 剩余有效时间
	 */
	public long getSafeTime() {
		return getSafeTime(TokenConstant.DEFAULT_SAFE_AUTH_SERVICE);
	}

	/**
	 * 获取当前会话的二级认证剩余有效时间 (单位: 秒, 返回-2代表尚未通过二级认证)
	 * @param service 业务标识  
	 * @return 剩余有效时间
	 */
	public long getSafeTime(String service) {
		// 如果上下文中没有 Token，则直接视为未认证 
		String tokenValue = getTokenValue();
		if(StringUtils.isEmpty(tokenValue)) {
			return TokenConstant.NOT_VALUE_EXPIRE;
		}
		
		// 从DB中查询这个key的剩余有效期 
		return getSaTokenDao().getTimeout(splicingKeySafe(tokenValue, service));
	}

	/**
	 * 在当前会话 结束二级认证 
	 */
	public void closeSafe() {
		closeSafe(TokenConstant.DEFAULT_SAFE_AUTH_SERVICE);
	}

	/**
	 * 在当前会话 结束二级认证 
	 * @param service 业务标识  
	 */
	public void closeSafe(String service) {
		// 如果上下文中没有 Token，则无需任何操作 
		String tokenValue = getTokenValue();
		if(StringUtils.isEmpty(tokenValue)) {
			return;
		}
		
		// 删除 key 
		getSaTokenDao().delete(splicingKeySafe(tokenValue, service));
		
		// $$ 发布事件 
//		SaTokenEventCenter.doCloseSafe(loginType, tokenValue, service);
	}

	
	// ------------------- 返回相应key -------------------  

	/**
	 * 拼接key：客户端 tokenName 
	 * @return key
	 */
	public String splicingKeyTokenName() {
 		return getConfig().getTokenName();
 	}
	
	/**  
	 * 拼接key： tokenValue 持久化 token-id
	 * @param tokenValue token值
	 * @return key
	 */
	public String splicingKeyTokenValue(String tokenValue) {
		return getConfig().getTokenName() + ":" + loginType + ":token:" + tokenValue;
	}
	
	/** 
	 * 拼接key： Session 持久化  
	 * @param loginId 账号id
	 * @return key
	 */
	public String splicingKeySession(Object loginId) {
		return getConfig().getTokenName() + ":" + loginType + ":session:" + loginId;
	}
	
	/**  
	 * 拼接key： tokenValue的Token-Session 
	 * @param tokenValue token值
	 * @return key
	 */
	public String splicingKeyTokenSession(String tokenValue) {
		return getConfig().getTokenName() + ":" + loginType + ":token-session:" + tokenValue;
	}
	
	/** 
	 * 拼接key： 指定token的最后操作时间 持久化 
	 * @param tokenValue token值
	 * @return key
	 */
	public String splicingKeyLastActivityTime(String tokenValue) {
		return getConfig().getTokenName() + ":" + loginType + ":last-activity:" + tokenValue;
	}

	/**
	 * 在进行身份切换时，使用的存储key 
	 * @return key
	 */
	public String splicingKeySwitch() {
		return TokenConstant.SWITCH_TO_SAVE_KEY + loginType;
	}

	/**
	 * 如果token为本次请求新创建的，则以此字符串为key存储在当前request中 
	 * @return key
	 */
	public String splicingKeyJustCreatedSave() {
//		return TokenConstant.JUST_CREATED_SAVE_KEY + loginType;
		return TokenConstant.JUST_CREATED;
	}

	/**  
	 * 拼接key： 账号封禁
	 * @param loginId 账号id
	 * @param service 具体封禁的服务 
	 * @return key 
	 */
	public String splicingKeyDisable(Object loginId, String service) {
		return getConfig().getTokenName() + ":" + loginType + ":disable:" + service + ":" + loginId;
	}

	/**  
	 * 拼接key： 二级认证 
	 * @param tokenValue 要认证的 Token 
	 * @param service 要认证的业务标识 
	 * @return key 
	 */
	public String splicingKeySafe(String tokenValue, String service) {
		// 格式：<Token名称>:<账号类型>:<safe>:<业务标识>:<Token值>
		// 形如：satoken:login:safe:important:gr_SwoIN0MC1ewxHX_vfCW3BothWDZMMtx__
		return getConfig().getTokenName() + ":" + loginType + ":safe:" + service + ":" + tokenValue;
	}

	
	// ------------------- Bean对象代理 -------------------  
	
	/**
	 * 返回全局配置对象 
	 * @return / 
	 */
	public TokenProperties getConfig() {
		// 为什么再次代理一层? 为某些极端业务场景下[需要不同StpLogic不同配置]提供便利 
		return SaManager.getConfig();
	}

	/**
	 * 返回全局配置对象的isShare属性 
	 * @return / 
	 */
	public boolean getConfigOfIsShare() {
		return getConfig().getIsShare();
	}

 	/**
 	 * 返回全局配置是否开启了Token 活跃校验
 	 * @return /
 	 */
 	public boolean isOpenActivityCheck() {
 		return getConfig().getActivityTimeout() != TokenConstant.NEVER_EXPIRE;
 	}

    /**
     * 返回全局配置的 Cookie 保存时长，单位：秒 （根据全局 timeout 计算）
     * @return Cookie 应该保存的时长
     */
    public int getConfigOfCookieTimeout() {
    	long timeout = getConfig().getTimeout();
    	if(timeout == TokenConstant.NEVER_EXPIRE) {
    		return Integer.MAX_VALUE;
    	}
		return (int) timeout;
	}
	
	/**
	 * 判断：集合中是否包含指定元素（模糊匹配）
	 * @param list 集合 
	 * @param element 元素 
	 * @return /
	 */
//	public boolean hasElement(List<String> list, String element) {
//		return SaStrategy.me.hasElement.apply(list, element);
//	}

	/**
	 * 返回持久化对象
	 * @return /
	 */
	public SaTokenDao getSaTokenDao() {
		return SaManager.getSaTokenDao();
	}

}
