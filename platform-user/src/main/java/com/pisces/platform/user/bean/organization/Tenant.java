package com.pisces.platform.user.bean.organization;

import com.pisces.framework.core.entity.BeanObject;
import com.pisces.framework.core.validator.constraints.Phone;
import com.pisces.framework.type.annotation.TableMeta;
import jakarta.validation.constraints.Email;
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
     * 租户代码
     */
    private Integer tenantCode;
    /**
     * 租户简称
     */
    private String shortName;
    /**
     * 租户全称
     */
    private String tenantName;

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
        this.tenantCode = 0;
        this.shortName = "";
        this.tenantName = "";
        this.telephone = "";
        this.email = "";
        this.address = "";
    }
}
