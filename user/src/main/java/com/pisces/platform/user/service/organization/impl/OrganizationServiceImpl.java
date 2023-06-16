package com.pisces.platform.user.service.organization.impl;

import com.pisces.framework.core.service.BaseServiceImpl;
import com.pisces.platform.user.bean.organization.Organization;
import com.pisces.platform.user.dao.organization.OrganizationDao;
import com.pisces.platform.user.service.organization.OrganizationService;
import org.springframework.stereotype.Service;

/**
 * 组织服务impl
 *
 * @author jason
 * @date 2022/12/07
 */
@Service
public class OrganizationServiceImpl extends BaseServiceImpl<Organization, OrganizationDao> implements OrganizationService {
}
