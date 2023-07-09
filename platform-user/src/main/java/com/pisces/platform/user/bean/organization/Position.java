package com.pisces.platform.user.bean.organization;

import com.pisces.framework.core.entity.BeanObject;
import com.pisces.framework.type.annotation.TableMeta;
import lombok.Getter;
import lombok.Setter;

/**
 * 岗位
 *
 * @author jason
 * @date 2022/12/03
 */
@Getter
@Setter
@TableMeta(name = "USER_POSITION")
public class Position extends BeanObject {
    /**
     * 岗位编码
     */
    private String positionCode;
    /**
     * 岗位名称
     */
    private String positionName;
    /**
     * 上级岗位
     */
    private String parentCode;

    /**
     * 备注
     */
    private String remark;

    @Override
    public void init() {
        super.init();
        positionCode = "";
        positionName = "";
        parentCode = "";
        remark = "";
    }
}
