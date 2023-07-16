package com.pisces.platform.user.bean.dataset;

import com.pisces.framework.core.entity.BeanObject;
import com.pisces.framework.type.annotation.TableMeta;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据集帐户
 *
 * @author jason
 * @date 2022/12/07
 */
@Getter
@Setter
@TableMeta(name = "USER_DATA_SET_ACCOUNT")
public class DataSetAccount extends BeanObject {
    private Boolean defaultDataSet;
    private Long accountId;
    private Long dataSetId;
    @Column
    private List<String> roles;

    @Override
    public void init() {
        super.init();
        defaultDataSet = false;
        accountId = 0L;
        dataSetId = 0L;
        roles = new ArrayList<>();
    }
}
