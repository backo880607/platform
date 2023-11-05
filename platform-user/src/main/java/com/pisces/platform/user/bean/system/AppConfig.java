package com.pisces.platform.user.bean.system;

import com.pisces.framework.core.entity.BeanAccount;
import com.pisces.framework.type.annotation.TableMeta;
import lombok.Getter;
import lombok.Setter;

/**
 * 应用配置
 *
 * @author jason
 * @date 2023/07/05
 */
@Getter
@Setter
@TableMeta(name = "USER_APP_CONFIG")
public class AppConfig extends BeanAccount {
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
