package com.pisces.platform.workflow.config;

import com.pisces.framework.core.config.BaseConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 语言自动配置
 *
 * @author jason
 * @date 2022/12/07
 */
@Configuration
@EnableConfigurationProperties({WorkflowProperties.class})
@PropertySource(ignoreResourceNotFound = true, value = "classpath:workflow.properties")
public class WorkflowAutoConfiguration extends BaseConfiguration {
}
