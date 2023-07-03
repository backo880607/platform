package com.pisces.platform.monitor.config;

import com.pisces.framework.core.config.BaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * maintenance属性
 *
 * @author jason
 * @date 2022/12/08
 */
@ConfigurationProperties(prefix = "pisces.platform.monitor")
public class MonitorProperties extends BaseProperties {
    public MonitorProperties() {
        super(MonitorConstant.IDENTIFY);
    }
}
