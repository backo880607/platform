package com.pisces.platform.user.controller.organization;

import com.pisces.framework.web.controller.BeanController;
import com.pisces.platform.user.bean.organization.Department;
import com.pisces.platform.user.config.UserConstant;
import com.pisces.platform.user.service.organization.DepartmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 部门控制器
 *
 * @author jason
 * @date 2022/12/07
 */
@RestController
@RequestMapping(UserConstant.IDENTIFY + "/Department")
class DepartmentController extends BeanController<Department, DepartmentService> {

}
