package com.pisces.platform.user.token.dao;

import com.pisces.platform.user.token.TokenManager;
import com.pisces.platform.user.token.session.SaSession;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Sa-Token持久层接口 [默认实现类, 基于内存Map]
 *
 * @author kong
 * @date 2023/07/24
 */
public class SaTokenDaoDefaultImpl implements SaTokenDao {

    /**
     * Token和账号的关系，一个账号支持多端登录，因此一个账号可能会有多个token
     */
    public Map<String, SaSession> sessionMap = new ConcurrentHashMap<>();

    /**
     * 过期时间集合 (单位: 毫秒) , 记录所有key的到期时间 [注意不是剩余存活时间]
     */
    public Map<String, Long> expireMap = new ConcurrentHashMap<>();

    /**
     * 构造函数
     */
    public SaTokenDaoDefaultImpl() {
        initRefreshThread();
    }


    // ------------------------ String 读写操作
    @Override
    public SaSession getSession(String account) {
        return sessionMap.get(account);
    }

    @Override
    public void setSession(SaSession session, long timeout) {
        if (timeout == 0 || timeout <= SaTokenDao.NOT_VALUE_EXPIRE) {
            return;
        }
        sessionMap.put(session.getAccount(), session);
//        expireMap.put(token, (timeout == SaTokenDao.NEVER_EXPIRE) ? (SaTokenDao.NEVER_EXPIRE) : (System.currentTimeMillis() + timeout * 1000));
    }

    @Override
    public void delete(String token) {
//        tokenAccount.remove(token);
        expireMap.remove(token);
    }

    @Override
    public long getTimeout(String token) {
        return getKeyTimeout(token);
    }

    @Override
    public void updateTimeout(String token, long timeout) {
        expireMap.put(token, (timeout == SaTokenDao.NEVER_EXPIRE) ? (SaTokenDao.NEVER_EXPIRE) : (System.currentTimeMillis() + timeout * 1000));
    }

    // ------------------------ 过期时间相关操作

    /**
     * 如果指定token已经过期，则立即清除它
     *
     * @param token 指定key
     */
    void clearKeyByTimeout(String token) {
        Long expirationTime = expireMap.get(token);
        // 清除条件：如果不为空 && 不是[永不过期] && 已经超过过期时间
        if (expirationTime != null && expirationTime != SaTokenDao.NEVER_EXPIRE && expirationTime < System.currentTimeMillis()) {
//            tokenAccount.remove(token);
            expireMap.remove(token);
        }
    }

    /**
     * 获取指定key的剩余存活时间 (单位：秒)
     */
    long getKeyTimeout(String token) {
        // 先检查是否已经过期
        clearKeyByTimeout(token);
        // 获取过期时间
        Long expire = expireMap.get(token);
        // 如果根本没有这个值
        if (expire == null) {
            return SaTokenDao.NOT_VALUE_EXPIRE;
        }
        // 如果被标注为永不过期
        if (expire == SaTokenDao.NEVER_EXPIRE) {
            return SaTokenDao.NEVER_EXPIRE;
        }
        // ---- 计算剩余时间并返回
        long timeout = (expire - System.currentTimeMillis()) / 1000;
        // 小于零时，视为不存在
        if (timeout < 0) {
//            tokenAccount.remove(token);
            expireMap.remove(token);
            return SaTokenDao.NOT_VALUE_EXPIRE;
        }
        return timeout;
    }


    // --------------------- 定时清理过期数据

    /**
     * 执行数据清理的线程
     */
    public Thread refreshThread;

    /**
     * 是否继续执行数据清理的线程标记
     */
    public volatile boolean refreshFlag;


    /**
     * 清理所有已经过期的key
     */
    public void refreshDataMap() {
        for (String s : expireMap.keySet()) {
            clearKeyByTimeout(s);
        }
    }

    /**
     * 初始化定时任务
     */
    public void initRefreshThread() {

        // 如果配置了<=0的值，则不启动定时清理
        if (TokenManager.getConfig().getDataRefreshPeriod() <= 0) {
            return;
        }
        // 启动定时刷新
        this.refreshFlag = true;
        this.refreshThread = new Thread(() -> {
            for (; ; ) {
                try {
                    try {
                        // 如果已经被标记为结束
                        if (refreshFlag == false) {
                            return;
                        }
                        // 执行清理
                        refreshDataMap();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    // 休眠N秒
                    int dataRefreshPeriod = TokenManager.getConfig().getDataRefreshPeriod();
                    if (dataRefreshPeriod <= 0) {
                        dataRefreshPeriod = 1;
                    }
                    Thread.sleep(dataRefreshPeriod * 1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.refreshThread.start();
    }

    /**
     * 结束定时任务
     */
    public void endRefreshThread() {
        this.refreshFlag = false;
    }
}
