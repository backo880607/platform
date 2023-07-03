package com.pisces.platform.user.bean.dataset;

import com.pisces.framework.core.entity.BeanObject;
import com.pisces.framework.type.annotation.TableMeta;
import lombok.Getter;
import lombok.Setter;

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

    @Override
    public void init() {
        super.init();
        this.defaultDataSet = false;
    }
}
