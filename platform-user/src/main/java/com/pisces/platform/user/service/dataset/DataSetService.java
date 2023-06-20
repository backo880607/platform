package com.pisces.platform.user.service.dataset;

import com.pisces.framework.core.service.BeanService;
import com.pisces.platform.user.bean.dataset.DataSet;

/**
 * 数据集服务
 *
 * @author jason
 * @date 2022/12/07
 */
public interface DataSetService extends BeanService<DataSet> {
    /**
     * 注册
     *
     * @param dataSet 数据集
     */
    void register(DataSet dataSet);

    /**
     * 注销
     *
     * @param dataSet 数据集
     */
    void unregister(DataSet dataSet);
}
