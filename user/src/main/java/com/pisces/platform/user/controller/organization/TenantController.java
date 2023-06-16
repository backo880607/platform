package com.pisces.platform.user.controller.organization;

import com.pisces.framework.web.controller.BaseController;
import com.pisces.framework.web.controller.ResponseData;
import com.pisces.platform.user.bean.organization.Tenant;
import com.pisces.platform.user.config.UserConstant;
import com.pisces.platform.user.service.organization.TenantService;
import org.springframework.web.bind.annotation.*;

/**
 * 租户控制器
 *
 * @author jason
 * @date 2022/12/07
 */
@RestController
@RequestMapping(UserConstant.IDENTIFY + "/Tenant")
class TenantController extends BaseController<Tenant, TenantService> {

    @PostMapping("register")
    public ResponseData register(@RequestBody Tenant tenant) {
        getService().register(tenant);
        return success();
    }

    @GetMapping("unregister")
    public ResponseData unregister(String tenantCode) {
        getService().unregister(tenantCode);
        return success();
    }
}
