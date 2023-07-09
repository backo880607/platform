package com.pisces.platform.user.bean.organization;

import com.pisces.framework.core.entity.BeanObject;
import com.pisces.framework.core.validator.constraints.Phone;
import com.pisces.framework.type.annotation.TableMeta;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * 租户
 *
 * @author jason
 * @date 2022/12/03
 */
@Getter
@Setter
@TableMeta(name = "USER_TENANT")
public class Tenant extends BeanObject {
    /**
     * 租户编码，一旦创建后即不能修改
     */
    private Integer tenantCode;
    /**
     * 租户简称
     */
    private String shortName;
    /**
     * 租户全称
     */
    @NotBlank
    private String tenantName;

    /**
     * 英文名字
     */
    private String englishName;

    /**
     * 租户Logo
     */
    private String tenantLogo;

    /**
     * 电话
     */
    @Phone
    private String telephone;
    /**
     * 电子邮件
     */
    @Email
    private String email;
    /**
     * 地址
     */
    private String address;

    @Override
    public void init() {
        super.init();
        tenantCode = 0;
        shortName = "";
        tenantName = "";
        englishName = "";
        tenantLogo = "";
        telephone = "";
        email = "";
        address = "";
    }
}
