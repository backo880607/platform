package com.pisces.platform.chat.config;

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
@EnableConfigurationProperties(ChatProperties.class)
@PropertySource(ignoreResourceNotFound = true, value = "classpath:chat.properties")
public class ChatAutoConfiguration extends BaseConfiguration {
}
