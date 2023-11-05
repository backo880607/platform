package com.pisces.platform.user.token.session;

import lombok.Getter;
import lombok.Setter;

/**
 * 令牌符号
 *
 * @author jason
 * @date 2023/07/24
 */
@Getter
@Setter
public class TokenSign {
    /**
     * Token 值
     */
    private String token;

    /**
     * 所属设备类型
     */
    private String device;
}
