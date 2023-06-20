package com.pisces.platform.user.bean.organization;

import com.pisces.framework.core.entity.BeanObject;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * 职位
 *
 * @author jason
 * @date 2022/12/03
 */
@Getter
@Setter
@Table(name = "USER_POSITION")
public class Position extends BeanObject {
    /**
     * 职位代码
     */
    private String positionCode;
    /**
     * 职位名称
     */
    private String positionName;

    /**
     * 备注
     */
    private String remark;

    @Override
    public void init() {
        super.init();
        this.positionCode = "";
        this.positionName = "";
        this.remark = "";
    }
}
