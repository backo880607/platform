package com.pisces.platform.user.controller.dataset;

import com.pisces.framework.core.utils.AppUtils;
import com.pisces.framework.core.utils.lang.Guard;
import com.pisces.framework.core.utils.lang.StringUtils;
import com.pisces.framework.core.validator.group.InsertGroup;
import com.pisces.framework.web.controller.BeanController;
import com.pisces.framework.web.controller.ResponseData;
import com.pisces.platform.user.bean.dataset.Account;
import com.pisces.platform.user.bean.dataset.DataSetAccount;
import com.pisces.platform.user.bean.organization.Employee;
import com.pisces.platform.user.config.UserConstant;
import com.pisces.platform.user.config.UserMessage;
import com.pisces.platform.user.dto.UserDataDto;
import com.pisces.platform.user.service.dataset.AccountService;
import jakarta.validation.groups.Default;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

/**
 * 帐户控制器
 *
 * @author jason
 * @date 2022/12/07
 */
@RestController
@RequestMapping(UserConstant.IDENTIFY + "/Account")
class AccountController extends BeanController<Account, AccountService> {

    @PostMapping("login")
    public ResponseData login(@RequestBody Account account) {
        getService().login(account);
        return null;
    }

    @GetMapping("getUserData")
    public ResponseData getUserData() {
        UserDataDto userData = new UserDataDto();
        Account account = getService().getByAccountName(AppUtils.getAccount());
        Guard.assertNotNull(account, UserMessage.AccountInvalid);
        userData.setAccountId(account.getId());
        userData.setUsername(account.getUsername());
        userData.setFullName(account.getFullName());
        userData.setAvatar(account.getAvatar());
        userData.setTelephone(account.getTelephone());
        userData.setEmail(account.getEmail());

        List<DataSetAccount> dataSets = getService().listDataSetAccounts(account);
        dataSets.sort(Comparator.comparing(DataSetAccount::getId));
        userData.setDataSets(dataSets);
        DataSetAccount lastDataSet = null;
        for (DataSetAccount dataSet : dataSets) {
            if (dataSet.getId().equals(account.getLastDataSet())) {
                lastDataSet = dataSet;
                break;
            }
        }
        if (lastDataSet == null && !dataSets.isEmpty()) {
            lastDataSet = dataSets.get(0);
        }
        userData.setLastDataSet(lastDataSet != null ? lastDataSet.getId() : 0L);
        if (StringUtils.isEmpty(account.getFullName())) {
            Employee employee = getService().getEmpolyee(account);
            if (employee != null) {
                userData.setFullName(employee.getEmployeeName());
            }
        }
        return success(userData);
    }

    @GetMapping("logout")
    public ResponseData logout() {
        getService().logout();
        return null;
    }

    @PostMapping("register")
    public ResponseData register(@RequestBody @Validated({InsertGroup.class, Default.class}) Account account) {
        getService().register(account);
        return success();
    }

    @RequestMapping("unregister")
    public ResponseData unregister(Account account) {
        getService().unregister(account);
        return success();
    }

    @PostMapping("resetPassword")
    public ResponseData resetPassword(String username, String password) {
        return success();
    }
}
