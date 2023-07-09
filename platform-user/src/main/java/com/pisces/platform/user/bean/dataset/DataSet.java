package com.pisces.platform.user.bean.dataset;

import com.pisces.framework.core.entity.BeanObject;
import com.pisces.framework.type.annotation.TableMeta;
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
@TableMeta(name = "USER_DATA_SET")
public class DataSet extends BeanObject {
    /**
     * 组织编码
     */
    private String orgCode;
    /**
     * 数据集编码，数据集编码可以修改，因此实际的数据应该根据数据集的ID进行关联。
     */
    private String dataSetCode;
    private String dataSetName;

    private Date endDate;
    private Integer maxLoginQty;
    private Integer maxAccountQty;
    private String remark;

    @Override
    public void init() {
        super.init();
        orgCode = "";
        dataSetCode = "";
        dataSetName = "";
        endDate = new Date();
        maxLoginQty = 5;
        maxAccountQty = 5;
        remark = "";
    }
}
