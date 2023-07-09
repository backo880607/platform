package com.pisces.platform.user.controller.permission;

import com.pisces.framework.web.controller.BeanController;
import com.pisces.platform.user.bean.permission.Role;
import com.pisces.platform.user.config.UserConstant;
import com.pisces.platform.user.service.permission.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色控制器
 *
 * @author jason
 * @date 2023/07/05
 */
@RestController
@RequestMapping(UserConstant.IDENTIFY + "/Role")
public class RoleController extends BeanController<Role, RoleService> {
}
