package com.pisces.platform.user.service.system.impl;

import com.pisces.framework.core.service.BeanServiceImpl;
import com.pisces.platform.user.bean.system.PasswordConfig;
import com.pisces.platform.user.dao.system.PasswordConfigDao;
import com.pisces.platform.user.service.system.PasswordConfigService;
import org.springframework.stereotype.Service;

/**
 * 密码配置服务impl
 *
 * @author jason
 * @date 2023/07/09
 */
@Service
public class PasswordConfigServiceImpl extends BeanServiceImpl<PasswordConfig, PasswordConfigDao> implements PasswordConfigService {
}
