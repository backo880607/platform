package com.pisces.platform.user.dao.system;

import com.pisces.framework.rds.common.SQLAccountDao;
import com.pisces.platform.user.bean.system.AppConfig;
import org.springframework.stereotype.Component;

/**
 * 应用程序配置刀
 *
 * @author jason
 * @date 2023/08/29
 */
@Component
public class AppConfigDao extends SQLAccountDao<AppConfig> {
}
