package com.pisces.platform.maintenance.config;

import com.pisces.framework.core.config.BaseConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * maintenance自动配置
 *
 * @author jason
 * @date 2022/12/08
 */
@Configuration
@EnableConfigurationProperties(MaintenanceProperties.class)
@PropertySource(ignoreResourceNotFound = true, value = "classpath:maintenance.properties")
public class MaintenanceAutoConfiguration extends BaseConfiguration {
}
