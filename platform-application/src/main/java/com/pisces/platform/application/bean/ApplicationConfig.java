package com.pisces.platform.application.bean;

import com.pisces.framework.core.entity.BeanAccount;
import com.pisces.framework.type.annotation.TableMeta;
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
@TableMeta(name = "PLATFORM_APPLICATION_CONFIG")
public class ApplicationConfig extends BeanAccount {
    private String lastApp;
    private String language;
    private String background;
    private String primaryColor;
    private Integer fontSize;

    @Override
    public void init() {
        super.init();
        lastApp = "platform";
        language = "zh-CN";
        background = "dark";
        primaryColor = "";
        fontSize = 100;
    }
}
