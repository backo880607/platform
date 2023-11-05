package com.pisces.platform.user.service.dataset.impl;

import com.pisces.framework.core.entity.AccountData;
import com.pisces.framework.core.exception.CommonException;
import com.pisces.framework.core.exception.ExistedException;
import com.pisces.framework.core.service.BeanServiceImpl;
import com.pisces.framework.core.utils.AppUtils;
import com.pisces.framework.core.utils.lang.Guard;
import com.pisces.framework.core.utils.lang.StringUtils;
import com.pisces.platform.user.bean.dataset.Account;
import com.pisces.platform.user.bean.dataset.DataSetAccount;
import com.pisces.platform.user.bean.dataset.table.QDataSetAccount;
import com.pisces.platform.user.bean.organization.Employee;
import com.pisces.platform.user.bean.organization.table.QEmployee;
import com.pisces.platform.user.config.UserMessage;
import com.pisces.platform.user.dao.dataset.AccountDao;
import com.pisces.platform.user.enums.system.LOGIN_TYPE;
import com.pisces.platform.user.service.dataset.AccountService;
import com.pisces.platform.user.service.dataset.DataSetAccountService;
import com.pisces.platform.user.service.organization.EmployeeService;
import com.pisces.platform.user.service.system.UserConfigService;
import com.pisces.platform.user.token.TokenUtil;
import jakarta.annotation.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * impl账户服务
 *
 * @author jason
 * @date 2022/12/07
 */
@Service
class AccountServiceImpl extends BeanServiceImpl<Account, AccountDao> implements AccountService {
    @Resource
    private UserConfigService configService;
    @Resource
    private EmployeeService employeeService;

    private static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    private static final String ROOT_ACCOUNT = "root";

    @Resource
    private DataSetAccountService dataSetAccountService;

    private Account fetchLoginAccount(Account request) {
        Account account = null;
        String accountName = "";
        LOGIN_TYPE loginType = configService.get().getLoginType();
        switch (loginType) {
            case USERNAME -> {
                accountName = Guard.value(request.getUsername()).trim();
                Guard.assertTrue(StringUtils.isNotEmpty(accountName), UserMessage.UsernameEmpty);
                account = getDao().getByUserName(accountName);
            }
            case EMAIL -> {
                accountName = Guard.value(request.getEmail()).trim();
                Guard.assertTrue(StringUtils.isNotEmpty(accountName), UserMessage.EmailEmpty);
                account = getDao().getByEmail(accountName);
            }
            case TELEPHONE -> {
                accountName = Guard.value(request.getTelephone()).trim();
                Guard.assertTrue(StringUtils.isNotEmpty(accountName), UserMessage.TelephoneEmpty);
                account = getDao().getByTelephone(accountName);
            }
        }
        if (account == null) {
            throw new CommonException(UserMessage.AccountInvalid, accountName);
        }
        return account;
    }

    private DataSetAccount fetchDataSetAccount(Account account) {
        DataSetAccount dataSetAccount = account.getLastDataSet() > 0 ? dataSetAccountService.getById(account.getLastDataSet()) : null;
        if (dataSetAccount == null) {
            List<DataSetAccount> dataSetAccounts = dataSetAccountService.list(QDataSetAccount.accountId.equal(account.getId()));
            for (DataSetAccount dataSet : dataSetAccounts) {
                if (dataSet.getDefaultDataSet()) {
                    dataSetAccount = dataSet;
                    break;
                } else if (dataSetAccount == null) {
                    dataSetAccount = dataSet;
                }
            }
        } else if (!dataSetAccountService.checkValid(dataSetAccount)) {
            throw new CommonException(UserMessage.UnbindDataSet, account.getUsername());
        }
        if (dataSetAccount == null) {
            throw new CommonException(UserMessage.UnbindDataSet, account.getUsername());
        }
        return dataSetAccount;
    }

    @Override
    public void login(Account request) {
        if (Guard.value(request.getUsername()).equals(ROOT_ACCOUNT)) {
            loginRoot();
            return;
        }
        Account account = fetchLoginAccount(request);
        DataSetAccount dataSetAccount = fetchDataSetAccount(account);
        List<String> roles = dataSetAccountService.fetchRoles(dataSetAccount);
        AccountData data = new AccountData();
        data.setAccount(account.getUsername());
        data.setTenant(account.getTenant());
        data.setDataSet(dataSetAccount.getDataSetId());
        data.setAuthorities(roles);
        TokenUtil.login(data);
    }

    @Override
    public void logout() {
        TokenUtil.logout();
    }

    private void loginRoot() {
        DataSetAccount dataSetAccount = dataSetAccountService.get();
        if (dataSetAccount == null) {
            throw new CommonException(UserMessage.UnbindDataSet, "ROOT");
        }
        AccountData data = new AccountData();
        data.setAccount(ROOT_ACCOUNT);
        data.setTenant(AppUtils.ROOT_TENANT);
        data.setDataSet(dataSetAccount.getDataSetId());
        data.getAuthorities().add("ROLE_ROOT");
        TokenUtil.login(data);
    }

    @Override
    public void register(Account account) {
        Account existed = getDao().getByUserName(account.getUsername());
        if (existed != null) {
            throw new ExistedException(UserMessage.UserExisted, account.getUsername());
        }
        account.setPassword(PASSWORD_ENCODER.encode(account.getPassword()));

        getBaseDao().insert(account);
    }

    @Override
    public void unregister(Account account) {
        Account existed = getDao().getByUserName(account.getUsername());
        if (existed == null) {
            throw new ExistedException(UserMessage.UserExisted, account.getUsername());
        }

        getBaseDao().delete(account);
    }

    @Override
    public Account getByAccountName(String accountName) {
        Guard.assertTrue(StringUtils.isNotBlank(accountName), UserMessage.AccountBlank);

        Account account = null;
        if (accountName.equals(ROOT_ACCOUNT)) {
            account = create();
            account.setUsername(ROOT_ACCOUNT);
            account.setFullName(lang.get(UserMessage.SuperAdmin));
            return account;
        }

        LOGIN_TYPE loginType = configService.get().getLoginType();
        switch (loginType) {
            case USERNAME -> account = getDao().getByUserName(accountName);
            case EMAIL -> account = getDao().getByEmail(accountName);
            case TELEPHONE -> account = getDao().getByTelephone(accountName);
        }
        return account;
    }

    @Override
    public List<DataSetAccount> listDataSetAccounts(Account account) {
        return dataSetAccountService.list(QDataSetAccount.accountId.equal(account.getId()));
    }

    @Override
    public Employee getEmpolyee(Account account) {
        if (account == null || StringUtils.isEmpty(account.getEmployeeCode())) {
            return null;
        }
        return employeeService.get(QEmployee.employeeCode.equal(account.getEmployeeCode()));
    }
}