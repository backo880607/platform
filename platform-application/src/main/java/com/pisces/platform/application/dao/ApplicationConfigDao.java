package com.pisces.platform.application.dao;

import com.pisces.platform.application.bean.ApplicationConfig;
import com.pisces.framework.rds.common.SQLAccountDao;
import org.springframework.stereotype.Component;

/**
 * 应用程序配置刀
 *
 * @author jason
 * @date 2022/12/07
 */
@Component
public class ApplicationConfigDao extends SQLAccountDao<ApplicationConfig> {
}
