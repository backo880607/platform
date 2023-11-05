package com.pisces.platform.user.config;

import lombok.Getter;
import lombok.Setter;

/**
 * 令牌配置
 *
 * @author jason
 * @date 2023/07/24
 */
@Getter
@Setter
public class TokenConfig {
    /**
     * token的长久有效期(单位:秒) 默认30天, -1代表永久
     */
    private long timeout = 60 * 60 * 24 * 30;

    /**
     * token临时有效期 [指定时间内无操作就视为token过期] (单位: 秒), 默认-1 代表不限制
     * (例如可以设置为1800代表30分钟内无操作就过期)
     */
    private long activityTimeout = -1;

    /**
     * 是否允许同一账号并发登录 (为true时允许一起登录, 为false时新登录挤掉旧登录)
     */
    private Boolean isConcurrent = true;

    /**
     * 同一账号最大登录数量，-1代表不限 （只有在 isConcurrent=true, isShare=false 时此配置才有效）
     */
    private int maxLoginCount = 12;

    /**
     * 默认dao层实现类中，每次清理过期数据间隔的时间 (单位: 秒) ，默认值30秒，设置为-1代表不启动定时清理
     */
    private int dataRefreshPeriod = 30;
}
