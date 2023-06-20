package com.pisces.platform.maintenance.config;

import com.pisces.framework.core.config.BaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * maintenance属性
 *
 * @author jason
 * @date 2022/12/08
 */
@ConfigurationProperties(prefix = "pisces.platform.maintenance")
public class MaintenanceProperties extends BaseProperties {
    public MaintenanceProperties() {
        super(MaintenanceConstant.IDENTIFY);
    }
}
