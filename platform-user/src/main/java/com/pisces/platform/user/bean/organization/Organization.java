package com.pisces.platform.user.bean.organization;

import com.pisces.framework.core.entity.BeanObject;
import com.pisces.framework.type.annotation.TableMeta;
import com.pisces.platform.user.enums.organization.ORGANIZATION_TYPE;
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
     * 组织代码
     */
    private String orgCode;
    /**
     * 组织名字
     */
    private String orgName;
    /**
     * 组织类型
     */
    private ORGANIZATION_TYPE type;

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
    private String linkPhone;
    /**
     * 介绍
     */
    private String introduction;

    @Override
    public void init() {
        super.init();
        orgCode = "";
        orgName = "";
        type = ORGANIZATION_TYPE.COMPANY;
        location = "";
        linkMan = "";
        linkPhone = "";
        introduction = "";
    }
}
