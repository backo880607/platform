package com.pisces.platform.user.service.organization;

import com.pisces.framework.core.service.BaseService;
import com.pisces.platform.user.bean.organization.Tenant;

/**
 * 租户服务
 *
 * @author jason
 * @date 2022/12/07
 */
public interface TenantService extends BaseService<Tenant> {
    /**
     * 注册
     *
     * @param tenant 租户
     */
    void register(Tenant tenant);

    /**
     * 注销
     *
     * @param tenantCode 租户
     */
    void unregister(String tenantCode);
}
