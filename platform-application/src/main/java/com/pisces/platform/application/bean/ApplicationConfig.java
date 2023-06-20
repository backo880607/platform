package com.pisces.platform.application.bean;

import com.pisces.framework.core.entity.EntityAccount;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * 应用程序配置
 *
 * @author Jason
 * @date 2022-03-24
 */
@Getter
@Setter
@Table(name = "PLATFORM_APPLICATION_CONFIG")
public class ApplicationConfig extends EntityAccount {
    private String lastApp;
    private String language;
    private String theme;

    @Override
    public void init() {
        super.init();
        lastApp = "platform";
        language = "zh-CN";
        theme = "dark";
    }
}
