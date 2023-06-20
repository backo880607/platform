package com.pisces.platform.user.config;

import com.pisces.framework.core.config.BaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * maintenance属性
 *
 * @author jason
 * @date 2022/12/08
 */
@ConfigurationProperties(prefix = "pisces.platform.user")
public class UserProperties extends BaseProperties {
    public UserProperties() {
        super(UserConstant.IDENTIFY);
    }
}
