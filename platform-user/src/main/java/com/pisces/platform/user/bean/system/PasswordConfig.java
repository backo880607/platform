package com.pisces.platform.user.bean.system;

import com.pisces.framework.core.entity.BeanObject;
import com.pisces.framework.type.annotation.TableMeta;
import lombok.Getter;
import lombok.Setter;

/**
 * 密码配置
 *
 * @author jason
 * @date 2023/07/09
 */
@Getter
@Setter
@TableMeta(name = "USER_PASSWORD_CONFIG")
public class PasswordConfig extends BeanObject {
    /**
     * 是否包含小写英文
     */
    private Boolean hasLower;
    /**
     * 是否包含大写英文
     */
    private Boolean hasUpper;
    /**
     * 是否包含特殊符号
     */
    private Boolean hasSpecial;
    /**
     * 是否包含数字
     */
    private Boolean hasDigit;
    /**
     * 最小长度
     */
    private Integer minLength;
    /**
     * 过期天数
     */
    private Integer expiration;
    /**
     * 失败登录次数
     */
    private Integer failLogin;

    @Override

    public void init() {
        super.init();
        hasLower = false;
        hasUpper = false;
        hasSpecial = false;
        hasDigit = false;
        minLength = 6;
        expiration = 90;
        failLogin = 5;
    }
}
