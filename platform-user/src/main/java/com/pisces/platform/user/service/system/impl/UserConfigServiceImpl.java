package com.pisces.platform.user.service.system.impl;

import com.pisces.framework.core.service.BeanServiceImpl;
import com.pisces.platform.user.bean.system.UserConfig;
import com.pisces.platform.user.dao.system.UserConfigDao;
import com.pisces.platform.user.service.system.UserConfigService;
import org.springframework.stereotype.Service;

/**
 * 用户配置服务impl
 *
 * @author jason
 * @date 2023/07/05
 */
@Service
public class UserConfigServiceImpl extends BeanServiceImpl<UserConfig, UserConfigDao> implements UserConfigService {
}
