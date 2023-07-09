package com.pisces.platform.user.token;

import com.pisces.framework.core.entity.AccountData;
import com.pisces.framework.core.utils.AppUtils;
import com.pisces.framework.web.context.PiscesContext;
import com.pisces.framework.web.context.PiscesResponse;
import com.pisces.framework.web.token.JwtTokenHelper;

/**
 * 令牌跑龙套
 *
 * @author jason
 * @date 2023/07/09
 */
public class TokenUtil {

    public static void login(AccountData data) {
        String token = JwtTokenHelper.generateToken(data);
        PiscesResponse response = AppUtils.getBean(PiscesContext.class).getResponse();
        response.addHeader("Authorization", "Bearer " + token);
    }
}
