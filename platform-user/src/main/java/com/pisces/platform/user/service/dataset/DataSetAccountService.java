package com.pisces.platform.user.service.dataset;

import com.pisces.framework.core.service.BeanService;
import com.pisces.platform.user.bean.dataset.DataSetAccount;

import java.util.List;

/**
 * 数据集账户服务
 *
 * @author jason
 * @date 2022/12/07
 */
public interface DataSetAccountService extends BeanService<DataSetAccount> {
    boolean checkValid(DataSetAccount dataSetAccount);

    List<String> fetchRoles(DataSetAccount dataSetAccount);
}
