package com.pisces.platform.user.bean.organization;

import com.pisces.framework.core.entity.BeanObject;
import com.pisces.framework.core.validator.constraints.Phone;
import com.pisces.framework.type.annotation.TableMeta;
import com.pisces.platform.user.enums.organization.ORGANIZATION_TYPE;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * 组织
 *
 * @author jason
 * @date 2022/12/03
 */
@Getter
@Setter
@TableMeta(name = "USER_ORGANIZATION")
public class Organization extends BeanObject {
    /**
     * 租户代码
     */
    private Integer tenantCode;
    /**
     * 父组织代码
     */
    private String parentOrgCode;
    /**
     * 组织代码
     */
    private String orgCode;
    /**
     * 组织简称
     */
    private String shortName;
    /**
     * 组织名字
     */
    @NotBlank
    private String orgName;
    /**
     * 英文名字
     */
    private String englishName;
    /**
     * 组织类型
     */
    private ORGANIZATION_TYPE type;
    /**
     * 组织logo
     */
    private String orgLogo;
    /**
     * 位置
     */
    private String location;
    /**
     * 联系人
     */
    private String linkMan;
    /**
     * 联系电话
     */
    @Phone
    private String linkPhone;
    /**
     * 传真
     */
    private String fax;
    /**
     * 电子邮件
     */
    @Email
    private String email;
    /**
     * 地址
     */
    private String address;
    /**
     * 官网
     */
    private String website;
    /**
     * 介绍
     */
    private String introduction;

    @Override
    public void init() {
        super.init();
        tenantCode = 0;
        parentOrgCode = "";
        orgCode = "";
        shortName = "";
        orgName = "";
        englishName = "";
        type = ORGANIZATION_TYPE.COMPANY;
        orgLogo = "";
        location = "";
        linkMan = "";
        linkPhone = "";
        fax = "";
        email = "";
        address = "";
        website = "";
        introduction = "";
    }
}
