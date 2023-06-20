package com.pisces.platform.chat.config;

import com.pisces.framework.core.config.BaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * chat属性
 *
 * @author jason
 * @date 2022/12/08
 */
@ConfigurationProperties(prefix = "pisces.platform.chat")
public class ChatProperties extends BaseProperties {
    public ChatProperties() {
        super(ChatConstant.IDENTIFY);
    }
}
