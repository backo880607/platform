package com.pisces.platform.user.bean.dataset;

import com.pisces.framework.core.entity.BeanObject;
import com.pisces.framework.type.annotation.TableMeta;
import com.pisces.platform.user.enums.organization.GENDER;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

/**
 * 账户
 *
 * @author jason
 * @date 2022/12/07
 */
@Getter
@Setter
@TableMeta(name = "USER_ACCOUNT")
public class Account extends BeanObject {
    private String username;
    private String fullName;
    private String avatar;
    private GENDER gender;
    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$")
    @NotBlank()
    private String telephone;
    @Email
    private String email;
    private String password;
    private String salt;
    private Boolean accountExpired;
    private Boolean accountLocked;
    private Boolean credentialsExpired;
    private Long lastDataSet;
    private Boolean enabled;

    @Override
    public void init() {
        super.init();
        username = "";
        fullName = "";
        password = "";
        salt = "";
        accountExpired = false;
        accountLocked = false;
        credentialsExpired = false;
        email = "";
        telephone = "";
        gender = GENDER.MALE;
        avatar = "";
        lastDataSet = 0L;
        enabled = true;
    }
}
