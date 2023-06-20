package com.pisces.platform.user.config;

import com.pisces.framework.core.config.BaseConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * user自动配置
 *
 * @author jason
 * @date 2022/12/08
 */
@Configuration
@EnableConfigurationProperties(UserProperties.class)
@PropertySource(ignoreResourceNotFound = true, value = "classpath:user.properties")
public class UserAutoConfiguration extends BaseConfiguration {
}
