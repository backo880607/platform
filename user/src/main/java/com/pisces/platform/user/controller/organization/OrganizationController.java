package com.pisces.platform.user.controller.organization;

import com.pisces.framework.web.controller.BaseController;
import com.pisces.platform.user.bean.organization.Organization;
import com.pisces.platform.user.config.UserConstant;
import com.pisces.platform.user.service.organization.OrganizationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 组织控制器
 *
 * @author jason
 * @date 2022/12/07
 */
@RestController
@RequestMapping(UserConstant.IDENTIFY + "/Organization")
class OrganizationController extends BaseController<Organization, OrganizationService> {
}
