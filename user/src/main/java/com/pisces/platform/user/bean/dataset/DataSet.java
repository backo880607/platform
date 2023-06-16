package com.pisces.platform.user.bean.dataset;

import com.pisces.framework.core.entity.BaseObject;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 数据集
 *
 * @author jason
 * @date 2022/12/07
 */
@Getter
@Setter
@Table(name = "USER_DATA_SET")
public class DataSet extends BaseObject {
    private String dataSetCode;
    private String dataSetName;

    private Date endDate;
    private Integer maxLoginQty;
    private Integer maxAccountQty;
    private String remark;

    @Override
    public void init() {
        super.init();
        this.dataSetCode = "";
        this.dataSetName = "";
        this.endDate = new Date();
        this.maxLoginQty = 5;
        this.maxAccountQty = 5;
        this.remark = "";
    }
}
