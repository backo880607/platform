package com.pisces.platform.user.service.dataset.impl;

import com.pisces.framework.core.service.BeanServiceImpl;
import com.pisces.platform.user.bean.dataset.DataSet;
import com.pisces.platform.user.bean.dataset.DataSetAccount;
import com.pisces.platform.user.bean.dataset.table.QDataSet;
import com.pisces.platform.user.dao.dataset.DataSetAccountDao;
import com.pisces.platform.user.service.dataset.DataSetAccountService;
import com.pisces.platform.user.service.dataset.DataSetService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 数据集impl帐户服务
 *
 * @author jason
 * @date 2022/12/07
 */
@Service
class DataSetAccountServiceImpl extends BeanServiceImpl<DataSetAccount, DataSetAccountDao> implements DataSetAccountService {
    @Resource
    private DataSetService dataSetService;

    @Override
    public boolean checkValid(DataSetAccount dataSetAccount) {
        DataSet dataSet = dataSetService.get(QDataSet.id.equal(dataSetAccount.getDataSetId()));
        if (dataSet == null) {
            return false;
        }
        return dataSetService.checkValid(dataSet);
    }
}
