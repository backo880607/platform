package com.pisces.platform.notification.config;

import com.pisces.framework.core.config.BaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * jms属性
 *
 * @author jason
 * @date 2022/12/08
 */
@ConfigurationProperties(prefix = "pisces.platform.notification")
public class NotificationProperties extends BaseProperties {
    public NotificationProperties() {
        super(NotificationConstant.IDENTIFY);
    }
}
