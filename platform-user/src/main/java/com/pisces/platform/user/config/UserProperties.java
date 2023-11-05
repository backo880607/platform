package com.pisces.platform.user.config;

import com.pisces.framework.core.config.BaseProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * maintenance属性
 *
 * @author jason
 * @date 2022/12/08
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "pisces.platform.user")
public class UserProperties extends BaseProperties {
    private TenantConfig tenant;
    private TokenConfig token = new TokenConfig();

    public UserProperties() {
        super(UserConstant.IDENTIFY);
    }
}
