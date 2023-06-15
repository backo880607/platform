package com.pisces.platform.token.config;

import com.pisces.framework.core.config.BaseProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 语言属性
 *
 * @author jason
 * @date 2022/12/07
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "pisces.platform.token")
public class TokenProperties extends BaseProperties {
    public TokenProperties() {
        super(TokenConstant.IDENTIFY);
    }

    /** token名称 (同时也是cookie名称) */
    private String tokenName = "satoken";

    /** token的长久有效期(单位:秒) 默认30天, -1代表永久 */
    private int timeout = 60 * 60 * 24 * 30;

    /**
     * token临时有效期 [指定时间内无操作就视为token过期] (单位: 秒), 默认-1 代表不限制
     * (例如可以设置为1800代表30分钟内无操作就过期)
     */
    private long activityTimeout = -1;

    /** 是否允许同一账号并发登录 (为true时允许一起登录, 为false时新登录挤掉旧登录) */
    private Boolean isConcurrent = true;

    /** 在多人登录同一账号时，是否共用一个token (为true时所有登录共用一个token, 为false时每次登录新建一个token) */
    private Boolean isShare = true;

    /**
     * 同一账号最大登录数量，-1代表不限 （只有在 isConcurrent=true, isShare=false 时此配置才有效）
     */
    private int maxLoginCount = 12;

    /**
     * jwt秘钥 (只有集成 jwt 模块时此参数才会生效)
     */
    private String jwtSecretKey;

    /** 默认dao层实现类中，每次清理过期数据间隔的时间 (单位: 秒) ，默认值30秒，设置为-1代表不启动定时清理 */
    private int dataRefreshPeriod = 30;
}
