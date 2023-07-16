package com.pisces.platform.email.config;

import com.pisces.framework.core.config.BaseConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * chat自动配置
 *
 * @author jason
 * @date 2022/12/08
 */
@Configuration
@EnableConfigurationProperties(EmailProperties.class)
@PropertySource(ignoreResourceNotFound = true, value = "classpath:email.properties")
public class EmailAutoConfiguration extends BaseConfiguration {
}
