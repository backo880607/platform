package com.pisces.platform.token.config;

/**
 * 语言常数
 *
 * @author jason
 * @date 2022/12/07
 */
public class TokenConstant {
    public static final String IDENTIFY = "token";

    // =================== 常量key标记 ===================

    /**
     * 常量key标记: 如果token为本次请求新创建的，则以此字符串为key存储在当前request中
     */
    public static final String JUST_CREATED = "JUST_CREATED_";

    /**
     * 常量key标记: 如果token为本次请求新创建的，则以此字符串为key存储在当前request中（不拼接前缀，纯Token）
     */
    public static final String JUST_CREATED_NOT_PREFIX = "JUST_CREATED_NOT_PREFIX_";

    /**
     * 常量key标记: 如果本次请求已经验证过[无操作过期], 则以此值存储在当前request中
     */
    public static final String TOKEN_ACTIVITY_TIMEOUT_CHECKED_KEY = "TOKEN_ACTIVITY_TIMEOUT_CHECKED_KEY_";

    /**
     * 常量key标记: 在登录时，默认使用的设备类型
     */
    public static final String DEFAULT_LOGIN_DEVICE = "default-device";

    /**
     * 常量key标记: 在封禁账号时，默认封禁的服务类型
     */
    public static final String DEFAULT_DISABLE_SERVICE = "login";

    /**
     * 常量key标记: 在封禁账号时，默认封禁的等级
     */
    public static final int DEFAULT_DISABLE_LEVEL = 1;

    /**
     * 常量key标记: 在封禁账号时，可使用的最小封禁级别
     */
    public static final int MIN_DISABLE_LEVEL = 1;

    /**
     * 常量key标记: 账号封禁级别，表示未被封禁
     */
    public static final int NOT_DISABLE_LEVEL = -2;

    /**
     * 常量key标记: 在进行临时身份切换时使用的key
     */
    public static final String SWITCH_TO_SAVE_KEY = "SWITCH_TO_SAVE_KEY_";

    /**
     * 常量key标记: 在进行Token二级验证时，使用的key
     */
    @Deprecated
    public static final String SAFE_AUTH_SAVE_KEY = "SAFE_AUTH_SAVE_KEY_";

    /**
     * 常量key标记: 在进行 Token 二级验证时，写入的 value 值
     */
    public static final String SAFE_AUTH_SAVE_VALUE = "SAFE_AUTH_SAVE_VALUE";

    /**
     * 常量key标记: 在进行 Token 二级验证时，默认的业务类型
     */
    public static final String DEFAULT_SAFE_AUTH_SERVICE = "important";

    /**
     * 常量key标记: 临时 Token 认证模块，默认的业务类型
     */
    public static final String DEFAULT_TEMP_TOKEN_SERVICE = "record";


    // =================== token-style 相关 ===================

    /**
     * Token风格: uuid
     */
    public static final String TOKEN_STYLE_UUID = "uuid";

    /**
     * Token风格: 简单uuid (不带下划线)
     */
    public static final String TOKEN_STYLE_SIMPLE_UUID = "simple-uuid";

    /**
     * Token风格: 32位随机字符串
     */
    public static final String TOKEN_STYLE_RANDOM_32 = "random-32";

    /**
     * Token风格: 64位随机字符串
     */
    public static final String TOKEN_STYLE_RANDOM_64 = "random-64";

    /**
     * Token风格: 128位随机字符串
     */
    public static final String TOKEN_STYLE_RANDOM_128 = "random-128";

    /**
     * Token风格: tik风格 (2_14_16)
     */
    public static final String TOKEN_STYLE_TIK = "tik";


    // =================== 其它 ===================

    /**
     * 连接Token前缀和Token值的字符
     */
    public static final String TOKEN_CONNECTOR_CHAT  = " ";

    /**
     * 切面、拦截器、过滤器等各种组件的注册优先级顺序
     */
    public static final int ASSEMBLY_ORDER = -100;

    /** 常量，表示一个key永不过期 (在一个key被标注为永远不过期时返回此值) */
    public static final long NEVER_EXPIRE = -1;

    /** 常量，表示系统中不存在这个缓存 (在对不存在的key获取剩余存活时间时返回此值) */
    public static final long NOT_VALUE_EXPIRE = -2;
}
