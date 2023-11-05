package com.pisces.platform.user.service.system.impl;

import com.pisces.framework.core.service.BeanServiceImpl;
import com.pisces.platform.user.bean.system.AppConfig;
import com.pisces.platform.user.dao.system.AppConfigDao;
import com.pisces.platform.user.service.system.AppConfigService;
import org.springframework.stereotype.Service;

/**
 * 应用程序配置服务impl
 *
 * @author jason
 * @date 2023/08/29
 */
@Service
public class AppConfigServiceImpl extends BeanServiceImpl<AppConfig, AppConfigDao> implements AppConfigService {
}
