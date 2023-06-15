package com.pisces.platform.jms.config;

import com.pisces.framework.core.config.BaseConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * jms自动配置
 *
 * @author jason
 * @date 2022/12/08
 */
@Configuration
@EnableConfigurationProperties(JmsProperties.class)
@PropertySource(ignoreResourceNotFound = true, value = "classpath:jms.properties")
public class JmsAutoConfiguration extends BaseConfiguration {
}
