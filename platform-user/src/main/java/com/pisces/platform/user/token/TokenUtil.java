package com.pisces.platform.user.token;

import com.pisces.framework.core.entity.AccountData;

/**
 * 令牌跑龙套
 *
 * @author jason
 * @date 2023/07/09
 */
public class TokenUtil {

    public static void login(AccountData data) {
        LoginModel model = new LoginModel();
        model.setAccountData(data);
        LoginHelper helper = new LoginHelper();
        helper.login(model);
    }

    public static void logout() {
        LoginHelper helper = new LoginHelper();
        helper.logout();
    }
}
