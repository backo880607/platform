package com.pisces.platform.user.token.dao;

import com.pisces.platform.user.token.session.SaSession;

/**
 * Sa-Token持久层接口
 *
 * @author kong
 */
public interface SaTokenDao {

    /**
     * 常量，表示一个key永不过期 (在一个key被标注为永远不过期时返回此值)
     */
    long NEVER_EXPIRE = -1;

    /**
     * 常量，表示系统中不存在这个缓存 (在对不存在的key获取剩余存活时间时返回此值)
     */
    long NOT_VALUE_EXPIRE = -2;


    // --------------------- Session读写 ---------------------

    /**
     * 根据账号ID获取Session数据
     *
     * @param account 账号ID
     * @return value
     */
    SaSession getSession(String account);

    /**
     * 写入Value，并设定存活时间 (单位: 秒)
     *
     * @param session 键名称
     * @param timeout 过期时间(值大于0时限时存储，值=-1时永久存储，值=0或小于-2时不存储)
     */
    void setSession(SaSession session, long timeout);

    /**
     * 删除Value
     *
     * @param token 键名称
     */
    void delete(String token);

    /**
     * 获取Value的剩余存活时间 (单位: 秒)
     *
     * @param token 指定key
     * @return 这个key的剩余存活时间
     */
    long getTimeout(String token);

    /**
     * 修改Value的剩余存活时间 (单位: 秒)
     *
     * @param token   指定key
     * @param timeout 过期时间
     */
    void updateTimeout(String token, long timeout);
}
