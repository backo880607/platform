package com.pisces.platform.user.token;

import com.pisces.framework.core.entity.AccountData;
import lombok.Data;

/**
 * 登录模式
 *
 * @author jason
 * @date 2023/07/26
 */
@Data
public class LoginModel {
    /**
     * 此次登录的账户
     */
    private AccountData accountData;
    /**
     * 此次登录的客户端设备类型
     */
    public String device;
    /**
     * 指定此次登录token的有效期, 单位:秒 （如未指定，自动取全局配置的timeout值）
     */
    public Long timeout;
}
