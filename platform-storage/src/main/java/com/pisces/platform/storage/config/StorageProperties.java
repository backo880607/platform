package com.pisces.platform.storage.config;

import com.pisces.framework.core.config.BaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * storage属性
 *
 * @author jason
 * @date 2022/12/08
 */
@ConfigurationProperties(prefix = "pisces.platform.storage")
public class StorageProperties extends BaseProperties {
    public StorageProperties() {
        super(StorageConstant.IDENTIFY);
    }
}
