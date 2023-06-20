package com.pisces.platform.user.service.organization.impl;

import com.pisces.framework.core.service.BeanServiceImpl;
import com.pisces.platform.user.bean.organization.Tenant;
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
//        LambdaQueryWrapper<Tenant> qw = Wrappers.lambdaQuery();
//        qw.eq(Tenant::getTenantCode, tenant.getTenantCode());
//        qw.orderByAsc(Tenant::getId);
//        String dddd = qw.getSqlSegment();
//        Tenant existed = getDao().get(qw);
//        if (existed != null) {
//            throw new RegisteredException(UserMessage.TenantExisted);
//        }
        insert(tenant);
    }

    @Override
    public void unregister(String tenantCode) {

    }

}
