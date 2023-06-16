package com.pisces.platform.user.controller.dataset;

import com.pisces.framework.web.controller.BaseController;
import com.pisces.framework.web.controller.ResponseData;
import com.pisces.platform.user.bean.dataset.Account;
import com.pisces.platform.user.bean.dataset.DataSetAccount;
import com.pisces.platform.user.config.UserConstant;
import com.pisces.platform.user.config.UserMessage;
import com.pisces.platform.user.dto.UserDataDto;
import com.pisces.platform.user.service.dataset.AccountService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
class AccountController extends BaseController<Account, AccountService> {
    private static final String ROOT_ACCOUNT = "root";

    @GetMapping("getUserData")
    public ResponseData getUserData() {
        UserDataDto userData = new UserDataDto();
//        Account account = getService().getByUserName(AppUtils.getUsername());
//        if (account == null) {
//            if (!AppUtils.getUsername().equals(ROOT_ACCOUNT)) {
//                throw new UserException("用户名【" + AppUtils.getUsername() + "】不存在");
//            }
//            account = getService().create();
//            account.setUsername("root");
//            account.setFullName(lang.get(UserMessage.SuperAdmin));
//        }
//        userData.setAccountId(account.getId());
//        userData.setUsername(account.getUsername());
//        userData.setFullName(account.getFullName());
//        userData.setAvatar(account.getAvatar());
//        userData.setTelephone(account.getTelephone());
//        userData.setEmail(account.getEmail());
//        List<DataSetAccount> dataSets = new ArrayList<>(account.getDataSets());
//        dataSets.sort(Comparator.comparing(DataSetAccount::getId));
//        userData.setDataSets(dataSets);
//        DataSetAccount lastDataSet = null;
//        for (DataSetAccount dataSet : dataSets) {
//            if (dataSet.getId().equals(account.getLastDataSet())) {
//                lastDataSet = dataSet;
//                break;
//            }
//        }
//        if (lastDataSet == null && !dataSets.isEmpty()) {
//            lastDataSet = dataSets.get(0);
//        }
//        userData.setLastDataSet(lastDataSet != null ? lastDataSet.getId() : 0L);
        return success(userData);
    }

//    @PostMapping("register")
//    public ResponseData register(@RequestBody @Validated({InsertGroup.class, Default.class}) Account account) {
//        getService().register(account);
//        return success();
//    }
//
//    @RequestMapping("unregister")
//    public ResponseData unregister(Account account) {
//        getService().unregister(account);
//        return success();
//    }

    @PostMapping("resetPassword")
    public ResponseData resetPassword(String username, String password) {
        return success();
    }
}
