package com.pisces.platform.user.service.organization.impl;

import com.pisces.framework.core.service.BeanServiceImpl;
import com.pisces.platform.user.bean.organization.DepartmentEmployee;
import com.pisces.platform.user.dao.organization.DepartmentEmployeeDao;
import com.pisces.platform.user.service.organization.DepartmentEmployeeService;
import org.springframework.stereotype.Service;

/**
 * 部门员工服务impl
 *
 * @author jason
 * @date 2022/12/07
 */
@Service
class DepartmentEmployeeServiceImpl extends BeanServiceImpl<DepartmentEmployee, DepartmentEmployeeDao> implements DepartmentEmployeeService {
}
