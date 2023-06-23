package com.pisces.platform.application.config;

import com.pisces.framework.core.config.BaseConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 应用程序自动配置
 *
 * @author jason
 * @date 2022/12/08
 */
@Configuration
@EnableConfigurationProperties({PlatformProperties.class})
@PropertySource(ignoreResourceNotFound = true, value = "classpath:platform.properties")
public class PlatformAutoConfiguration extends BaseConfiguration {
}
