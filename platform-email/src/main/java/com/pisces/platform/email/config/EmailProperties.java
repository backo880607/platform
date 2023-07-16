package com.pisces.platform.email.config;

import com.pisces.framework.core.config.BaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * chat属性
 *
 * @author jason
 * @date 2022/12/08
 */
@ConfigurationProperties(prefix = "pisces.platform.email")
public class EmailProperties extends BaseProperties {
    public EmailProperties() {
        super(EmailConstant.IDENTIFY);
    }
}
