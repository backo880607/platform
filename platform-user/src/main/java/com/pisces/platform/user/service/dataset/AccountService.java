package com.pisces.platform.user.service.dataset;

import com.pisces.framework.core.service.BeanService;
import com.pisces.platform.user.bean.dataset.Account;
import com.pisces.platform.user.bean.dataset.DataSetAccount;

import java.util.List;

/**
 * 帐户服务
 *
 * @author jason
 * @date 2022/12/07
 */
public interface AccountService extends BeanService<Account> {
    /**
     * 登录
     *
     * @param account 账户
     */
    void login(Account account);

    /**
     * 注册账户
     *
     * @param account 账户
     */
    void register(Account account);

    /**
     * 注销账户
     *
     * @param account 账户
     */
    void unregister(Account account);

    /**
     * 根据账号名获取账号信息
     *
     * @param accountName 账号名
     * @return {@link Account}
     */
    Account getByAccountName(String accountName);

    /**
     * 列表数据集账户
     *
     * @param account 账户
     * @return {@link List}<{@link DataSetAccount}>
     */
    List<DataSetAccount> listDataSetAccounts(Account account);
}
