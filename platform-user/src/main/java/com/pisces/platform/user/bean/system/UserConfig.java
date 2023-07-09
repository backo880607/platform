package com.pisces.platform.user.bean.system;

import com.pisces.framework.core.entity.BeanObject;
import com.pisces.framework.type.annotation.TableMeta;
import com.pisces.platform.user.enums.system.LOGIN_TYPE;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户配置
 *
 * @author jason
 * @date 2023/07/05
 */
@Getter
@Setter
@TableMeta(name = "USER_CONFIG")
public class UserConfig extends BeanObject {
    private String initPassword;
    private LOGIN_TYPE loginType;

    @Override
    public void init() {
        super.init();
        initPassword = "123456";
        loginType = LOGIN_TYPE.USERNAME;
    }
}
