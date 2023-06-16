package com.pisces.platform.user.service.organization.impl;

import com.pisces.framework.core.service.BaseServiceImpl;
import com.pisces.platform.user.bean.organization.Employee;
import com.pisces.platform.user.dao.organization.EmployeeDao;
import com.pisces.platform.user.service.organization.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * 员工服务impl
 *
 * @author jason
 * @date 2022/12/07
 */
@Service
class EmployeeServiceImpl extends BaseServiceImpl<Employee, EmployeeDao> implements EmployeeService {
}
