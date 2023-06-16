package com.pisces.platform.user.service.dataset.impl;

import com.pisces.framework.core.service.BaseServiceImpl;
import com.pisces.platform.user.bean.dataset.Account;
import com.pisces.platform.user.bean.dataset.DataSetAccount;
import com.pisces.platform.user.config.UserMessage;
import com.pisces.platform.user.dao.dataset.AccountDao;
import com.pisces.platform.user.dao.dataset.DataSetAccountDao;
import com.pisces.platform.user.service.dataset.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * impl账户服务
 *
 * @author jason
 * @date 2022/12/07
 */
@Service
class AccountServiceImpl extends BaseServiceImpl<Account, AccountDao> implements AccountService {
    private static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    private static final String ROOT_ACCOUNT = "root";

    @Autowired
    private DataSetAccountDao dataSetAccountDao;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        List<String> roles = new ArrayList<>();
//        long dataSetId = 0L;
//        Account account = getDao().getByUserName(username);
//        if (account == null) {
//            if (username.equals(ROOT_ACCOUNT)) {
//                account = create();
//                account.setUsername("root");
//                account.setPassword(PASSWORD_ENCODER.encode("123456"));
//                account.setLastDataSet(AppUtils.ROOT_DATASET);
//                dataSetId = AppUtils.ROOT_DATASET;
//                roles.add("root");
//            } else {
//                throw new UsernameNotFoundException(username);
//            }
//        } else {
//            DataSetAccount lastDataSet = null;
//            if (account.getLastDataSet() > 0) {
//                lastDataSet = dataSetAccountDao.getById(account.getLastDataSet());
//            }
//            if (lastDataSet == null) {
//                Collection<DataSetAccount> dataSetAccounts = account.getDataSets();
//                for (DataSetAccount dataSet : dataSetAccounts) {
//                    if (dataSet.getDefaultDataSet()) {
//                        lastDataSet = dataSet;
//                        break;
//                    } else if (lastDataSet == null) {
//                        lastDataSet = dataSet;
//                    }
//                }
//                if (lastDataSet != null) {
//                    account.setLastDataSet(lastDataSet.getId());
//                    update(account);
//                }
//            }
//            if (lastDataSet != null) {
//                dataSetId = lastDataSet.getDataSet() != null ? lastDataSet.getDataSet().getId() : 0L;
//                Role role = lastDataSet.getRole();
//                if (role != null) {
//                    roles.add(role.getRoleCode());
//                }
//            }
//        }
//
//        List<SimpleGrantedAuthority> authList = getAuthorities(roles);
//        return new AuthenticationUser(username, account.getPassword(), dataSetId,
//                account.getEnabled(), !account.getAccountExpired(), !account.getCredentialsExpired(), !account.getAccountLocked(), authList);
//    }
//
//    private List<SimpleGrantedAuthority> getAuthorities(List<String> roles) {
//        List<SimpleGrantedAuthority> authList = new ArrayList<>();
//        for (String role : roles) {
//            authList.add(new SimpleGrantedAuthority("ROLE_" + role.toUpperCase()));
//        }
//        return authList;
//    }
//
//    @Override
//    public void register(Account account) {
//        Account existed = getDao().getByUserName(account.getUsername());
//        if (existed != null) {
//            throw new ExistedException(UserMessage.UserExisted, account.getUsername());
//        }
//        account.setPassword(PASSWORD_ENCODER.encode(account.getPassword()));
//
//        getBaseDao().insert(account);
//    }
//
//    @Override
//    public void unregister(Account account) {
//        Account existed = getDao().getByUserName(account.getUsername());
//        if (existed == null) {
//            throw new ExistedException(UserMessage.UserExisted, account.getUsername());
//        }
//
//        getBaseDao().delete(account);
//    }
//
//    @Override
//    public Account getByUserName(String username) {
//        return getDao().getByUserName(username);
//    }
}