package com.pisces.platform.storage.config;

import com.pisces.framework.core.config.BaseConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * storage自动配置
 *
 * @author jason
 * @date 2022/12/08
 */
@Configuration
@EnableConfigurationProperties(StorageProperties.class)
@PropertySource(ignoreResourceNotFound = true, value = "classpath:storage.properties")
public class StorageAutoConfiguration extends BaseConfiguration {
}
