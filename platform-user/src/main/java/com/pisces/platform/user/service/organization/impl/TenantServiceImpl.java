package com.pisces.platform.user.service.organization.impl;

import com.pisces.framework.core.service.BeanServiceImpl;
import com.pisces.framework.core.utils.lang.Guard;
import com.pisces.platform.user.bean.organization.Tenant;
import com.pisces.platform.user.bean.organization.table.QTenant;
import com.pisces.platform.user.config.UserMessage;
import com.pisces.platform.user.dao.organization.TenantDao;
import com.pisces.platform.user.service.organization.TenantService;
import org.springframework.stereotype.Service;

/**
 * 租户服务impl
 *
 * @author jason
 * @date 2022/12/07
 */
@Service
class TenantServiceImpl extends BeanServiceImpl<Tenant, TenantDao> implements TenantService {

    @Override
    public void register(Tenant tenant) {
        Guard.assertTrue(Guard.value(tenant.getTenantCode()) > 0, UserMessage.TenantCodeInvalid);
        Tenant existed = get(QTenant.tenantCode.equal(tenant.getTenantCode()));
        Guard.assertNull(existed, UserMessage.TenantExisted);
        insert(tenant);
    }

    @Override
    public void unregister(String tenantCode) {

    }

}
