package com.pisces.platform.user.service.dataset.impl;

import com.pisces.framework.core.service.BeanServiceImpl;
import com.pisces.framework.core.utils.lang.CollectionUtils;
import com.pisces.platform.user.bean.dataset.DataSet;
import com.pisces.platform.user.bean.dataset.DataSetAccount;
import com.pisces.platform.user.bean.dataset.table.QDataSet;
import com.pisces.platform.user.bean.permission.Role;
import com.pisces.platform.user.bean.permission.table.QRole;
import com.pisces.platform.user.dao.dataset.DataSetAccountDao;
import com.pisces.platform.user.service.dataset.DataSetAccountService;
import com.pisces.platform.user.service.dataset.DataSetService;
import com.pisces.platform.user.service.permission.RoleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    @Resource
    private RoleService roleService;

    @Override
    public boolean checkValid(DataSetAccount dataSetAccount) {
        DataSet dataSet = dataSetService.get(QDataSet.id.equal(dataSetAccount.getDataSetId()));
        if (dataSet == null) {
            return false;
        }
        return dataSetService.checkValid(dataSet);
    }

    @Override
    public List<String> fetchRoles(DataSetAccount dataSetAccount) {
        if (CollectionUtils.isEmpty(dataSetAccount.getRoles())) {
            return new ArrayList<>();
        }
        List<Role> roles = roleService.list(QRole.roleCode.in(dataSetAccount.getRoles()));
        return roles.stream().map(Role::getRoleCode).collect(Collectors.toList());
    }
}
