package com.pisces.platform.user.bean.organization;

import com.pisces.framework.core.entity.BeanObject;
import com.pisces.framework.type.annotation.TableMeta;
import lombok.Getter;
import lombok.Setter;

/**
 * 部门
 *
 * @author jason
 * @date 2022/12/03
 */
@Getter
@Setter
@TableMeta(name = "USER_DEPARTMENT")
public class Department extends BeanObject {
    /**
     * 部门代码
     */
    private String departmentCode;
    /**
     * 部门名称
     */
    private String departmentName;
    /**
     * 上级部门编码
     */
    private String parentCode;
    /**
     * 组织代码
     */
    private String orgCode;

    private String remark;

    @Override
    public void init() {
        super.init();
        departmentCode = "";
        departmentName = "";
        parentCode = "";
        orgCode = "";
        remark = "";
    }
}
