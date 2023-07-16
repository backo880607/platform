package com.pisces.platform.user.config;

import lombok.Getter;
import lombok.Setter;

/**
 * 租户配置
 *
 * @author jason
 * @date 2023/07/14
 */
@Getter
@Setter
public class TenantConfig {
    private Integer sectorCode = 2;
    private Integer tenantCode = 4;
}
