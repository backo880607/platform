package com.pisces.platform.user.bean.organization;

import com.pisces.framework.core.entity.BaseObject;
import jakarta.persistence.Table;
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
@Table(name = "USER_DEPARTMENT")
public class Department extends BaseObject {
    /**
     * 部门代码
     */
    private String departmentCode;
    /**
     * 部门名称
     */
    private String departmentName;

    private String remark;

    @Override
    public void init() {
        super.init();
        this.departmentCode = "";
        this.departmentName = "";
        this.remark = "";
    }
}
