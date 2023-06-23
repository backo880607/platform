package com.pisces.platform.application.config;

import com.pisces.framework.core.config.BaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 应用程序属性
 *
 * @author jason
 * @date 2022/12/08
 */
@ConfigurationProperties(prefix = "pisces.platform.application")
public class PlatformProperties extends BaseProperties {
    public PlatformProperties() {
        super(PlatformConstant.IDENTIFY);
    }
}
