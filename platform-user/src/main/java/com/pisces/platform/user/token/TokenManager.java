package com.pisces.platform.user.token;

import com.pisces.framework.core.utils.AppUtils;
import com.pisces.platform.user.config.TokenConfig;
import com.pisces.platform.user.config.UserProperties;
import com.pisces.platform.user.token.dao.SaTokenDao;
import com.pisces.platform.user.token.dao.SaTokenDaoDefaultImpl;

/**
 * 令牌管理器
 *
 * @author jason
 * @date 2023/07/24
 */
public class TokenManager {
    public volatile static TokenConfig config;
    private volatile static SaTokenDao saTokenDao;

    public static TokenConfig getConfig() {
        if (config == null) {
            synchronized (TokenManager.class) {
                if (config == null) {
                    config = AppUtils.getBean(UserProperties.class).getToken();
                }
            }
        }
        return config;
    }

    public static void setSaTokenDao(SaTokenDao saTokenDao) {
        setSaTokenDaoMethod(saTokenDao);
    }

    private static void setSaTokenDaoMethod(SaTokenDao saTokenDao) {
        if ((TokenManager.saTokenDao instanceof SaTokenDaoDefaultImpl)) {
            ((SaTokenDaoDefaultImpl) TokenManager.saTokenDao).endRefreshThread();
        }
        TokenManager.saTokenDao = saTokenDao;
    }

    public static SaTokenDao getSaTokenDao() {
        if (saTokenDao == null) {
            synchronized (TokenManager.class) {
                if (saTokenDao == null) {
                    setSaTokenDaoMethod(new SaTokenDaoDefaultImpl());
                }
            }
        }
        return saTokenDao;
    }
}
