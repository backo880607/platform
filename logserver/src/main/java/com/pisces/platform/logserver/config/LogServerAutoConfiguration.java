package com.pisces.platform.logserver.config;

import com.pisces.framework.core.config.BaseConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * logserver自动配置
 *
 * @author jason
 * @date 2022/12/08
 */
@Configuration
@EnableConfigurationProperties(LogServerProperties.class)
@PropertySource(ignoreResourceNotFound = true, value = "classpath:logserver.properties")
public class LogServerAutoConfiguration extends BaseConfiguration {
}
