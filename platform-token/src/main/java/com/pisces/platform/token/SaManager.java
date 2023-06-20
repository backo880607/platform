package com.pisces.platform.token;

import com.pisces.framework.core.utils.AppUtils;
import com.pisces.platform.token.config.TokenProperties;
import com.pisces.platform.token.login.SaTokenDao;
import com.pisces.platform.token.login.SaTokenDaoDefaultImpl;
import com.pisces.platform.token.utils.StpUtil;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 管理 Sa-Token 所有全局组件  
 * @author kong
 *
 */
public class SaManager {

	/**
	 * 配置文件 Bean 
	 */
	public volatile static TokenProperties config;
	public static void setConfig(TokenProperties config) {
		setConfigMethod(config);
		
		// $$ 全局事件 
//		SaTokenEventCenter.doSetConfig(config);
		
		// 调用一次StpUtil中的方法，保证其可以尽早的初始化 StpLogic 
		StpUtil.getLoginType();
	}
	private static void setConfigMethod(TokenProperties config) {
		SaManager.config = config;
	}
	public static TokenProperties getConfig() {
		if (config == null) {
			synchronized (SaManager.class) {
				if (config == null) {
					setConfigMethod(AppUtils.getBean(TokenProperties.class));
				}
			}
		}
		return config;
	}

	/**
	 * 持久化 Bean
	 */
	private volatile static SaTokenDao saTokenDao;
	public static void setSaTokenDao(SaTokenDao saTokenDao) {
		setSaTokenDaoMethod(saTokenDao);
//		SaTokenEventCenter.doRegisterComponent("SaTokenDao", saTokenDao);
	}
	private static void setSaTokenDaoMethod(SaTokenDao saTokenDao) {
		if((SaManager.saTokenDao instanceof SaTokenDaoDefaultImpl)) {
			((SaTokenDaoDefaultImpl)SaManager.saTokenDao).endRefreshThread();
		}
		SaManager.saTokenDao = saTokenDao;
	}
	public static SaTokenDao getSaTokenDao() {
		if (saTokenDao == null) {
			synchronized (SaManager.class) {
				if (saTokenDao == null) {
					setSaTokenDaoMethod(new SaTokenDaoDefaultImpl());
				}
			}
		}
		return saTokenDao;
	}
}
