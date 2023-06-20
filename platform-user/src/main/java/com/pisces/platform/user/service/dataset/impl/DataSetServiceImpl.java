package com.pisces.platform.user.service.dataset.impl;

import com.pisces.framework.core.service.BeanServiceImpl;
import com.pisces.platform.user.bean.dataset.DataSet;
import com.pisces.platform.user.dao.dataset.DataSetDao;
import com.pisces.platform.user.service.dataset.DataSetService;
import org.springframework.stereotype.Service;

/**
 * 数据集服务impl
 *
 * @author jason
 * @date 2022/12/07
 */
@Service
class DataSetServiceImpl extends BeanServiceImpl<DataSet, DataSetDao> implements DataSetService {

    @Override
    public void register(DataSet dataSet) {

    }

    @Override
    public void unregister(DataSet dataSet) {

    }

}
