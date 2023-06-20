package com.pisces.platform.user.service.organization.impl;

import com.pisces.framework.core.service.BeanServiceImpl;
import com.pisces.platform.user.bean.organization.Department;
import com.pisces.platform.user.dao.organization.DepartmentDao;
import com.pisces.platform.user.service.organization.DepartmentService;
import org.springframework.stereotype.Service;

/**
 * 部门服务impl
 *
 * @author jason
 * @date 2022/12/07
 */
@Service
class DepartmentServiceImpl extends BeanServiceImpl<Department, DepartmentDao> implements DepartmentService {

}
