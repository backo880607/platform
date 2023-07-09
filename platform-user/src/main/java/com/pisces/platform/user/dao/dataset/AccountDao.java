package com.pisces.platform.user.dao.dataset;

import com.pisces.framework.rds.common.SQLDao;
import com.pisces.platform.user.bean.dataset.Account;
import com.pisces.platform.user.bean.dataset.table.QAccount;
import org.springframework.stereotype.Component;

/**
 * 账户刀
 *
 * @author jason
 * @date 2022/12/07
 */
@Component
public class AccountDao extends SQLDao<Account> {

    public Account getByUserName(String username) {
        return get(QAccount.username.equal(username));
    }

    public Account getByEmail(String email) {
        return get(QAccount.email.equal(email));
    }

    public Account getByTelephone(String telephone) {
        return get(QAccount.telephone.equal(telephone));
    }
}
