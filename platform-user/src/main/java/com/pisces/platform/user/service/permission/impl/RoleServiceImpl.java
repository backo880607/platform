package com.pisces.platform.user.service.permission.impl;

import com.pisces.framework.core.service.BeanServiceImpl;
import com.pisces.platform.user.bean.permission.Role;
import com.pisces.platform.user.dao.permission.RoleDao;
import com.pisces.platform.user.service.permission.RoleService;
import org.springframework.stereotype.Service;

/**
 * 角色服务impl
 *
 * @author jason
 * @date 2023/07/05
 */
@Service
public class RoleServiceImpl extends BeanServiceImpl<Role, RoleDao> implements RoleService {
}
