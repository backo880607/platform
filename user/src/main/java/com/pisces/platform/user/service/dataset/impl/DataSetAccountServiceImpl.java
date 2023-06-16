package com.pisces.platform.user.service.dataset.impl;

import com.pisces.framework.core.service.BaseServiceImpl;
import com.pisces.platform.user.bean.dataset.DataSetAccount;
import com.pisces.platform.user.dao.dataset.DataSetAccountDao;
import com.pisces.platform.user.service.dataset.DataSetAccountService;
import org.springframework.stereotype.Service;

/**
 * 数据集impl帐户服务
 *
 * @author jason
 * @date 2022/12/07
 */
@Service
class DataSetAccountServiceImpl extends BaseServiceImpl<DataSetAccount, DataSetAccountDao> implements DataSetAccountService {
}
