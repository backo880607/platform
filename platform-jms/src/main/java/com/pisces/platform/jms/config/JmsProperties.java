package com.pisces.platform.jms.config;

import com.pisces.framework.core.config.BaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * jms属性
 *
 * @author jason
 * @date 2022/12/08
 */
@ConfigurationProperties(prefix = "pisces.platform.jms")
public class JmsProperties extends BaseProperties {
    public JmsProperties() {
        super(JmsConstant.IDENTIFY);
    }
}
