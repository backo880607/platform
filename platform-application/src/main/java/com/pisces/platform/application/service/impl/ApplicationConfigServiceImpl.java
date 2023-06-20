package com.pisces.platform.application.service.impl;

import com.pisces.framework.core.service.BeanServiceImpl;
import com.pisces.platform.application.bean.ApplicationConfig;
import com.pisces.platform.application.dao.ApplicationConfigDao;
import com.pisces.platform.application.service.ApplicationConfigService;
import org.springframework.stereotype.Service;

/**
 * 应用程序配置服务impl
 *
 * @author jason
 * @date 2022/12/07
 */
@Service
public class ApplicationConfigServiceImpl extends BeanServiceImpl<ApplicationConfig, ApplicationConfigDao> implements ApplicationConfigService {
}
