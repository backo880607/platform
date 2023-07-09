package com.pisces.platform.user.bean.permission;

import com.pisces.framework.core.entity.BeanObject;
import com.pisces.framework.type.annotation.PropertyMeta;
import com.pisces.framework.type.annotation.TableMeta;
import lombok.Getter;
import lombok.Setter;

/**
 * 角色
 *
 * @author jason
 * @date 2023/07/05
 */
@Getter
@Setter
@TableMeta(name = "USER_ROLE")
public class Role extends BeanObject {
    private String roleCode;
    @PropertyMeta(popDisplay = true)
    private String roleName;
    @PropertyMeta(popDisplay = true)
    private String remarks;
    private Long accountId;
    private Long dataSetId;

    @Override
    public void init() {
        super.init();
        roleCode = "";
        roleName = "";
        remarks = "";
        accountId = 0L;
        dataSetId = 0L;
    }
}
