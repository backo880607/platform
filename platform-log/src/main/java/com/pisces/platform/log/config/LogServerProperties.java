package com.pisces.platform.log.config;

import com.pisces.framework.core.config.BaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * logserver属性
 *
 * @author jason
 * @date 2022/12/08
 */
@ConfigurationProperties(prefix = "pisces.platform.logserver")
public class LogServerProperties extends BaseProperties {
    public LogServerProperties() {
        super(LogServerConstant.IDENTIFY);
    }
}
