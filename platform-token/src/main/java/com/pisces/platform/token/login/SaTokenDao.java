package com.pisces.platform.token.login;

import java.util.List;

/**
 * Sa-Token持久层接口 
 * @author kong 
 */
public interface SaTokenDao {

	/** 常量，表示一个key永不过期 (在一个key被标注为永远不过期时返回此值) */ 
	static final long NEVER_EXPIRE = -1;
	
	/** 常量，表示系统中不存在这个缓存 (在对不存在的key获取剩余存活时间时返回此值) */ 
	static final long NOT_VALUE_EXPIRE = -2;

	
	// --------------------- 字符串读写 ---------------------
	
	/**
	 * 获取Value，如无返空 
	 * @param key 键名称 
	 * @return value
	 */
	String get(String key);

	/**
	 * 写入Value，并设定存活时间 (单位: 秒)
	 * @param key 键名称 
	 * @param value 值 
	 * @param timeout 过期时间(值大于0时限时存储，值=-1时永久存储，值=0或小于-2时不存储)
	 */
	void set(String key, String value, long timeout);

	/**
	 * 更新Value (过期时间不变) 
	 * @param key 键名称 
	 * @param value 值 
	 */
	void update(String key, String value);

	/**
	 * 删除Value 
	 * @param key 键名称 
	 */
	void delete(String key);
	
	/**
	 * 获取Value的剩余存活时间 (单位: 秒) 
	 * @param key 指定key 
	 * @return 这个key的剩余存活时间 
	 */
	long getTimeout(String key);
	
	/**
	 * 修改Value的剩余存活时间 (单位: 秒) 
	 * @param key 指定key
	 * @param timeout 过期时间 
	 */
	void updateTimeout(String key, long timeout);

	
	// --------------------- 对象读写 ---------------------

	/**
	 * 获取Object，如无返空 
	 * @param key 键名称 
	 * @return object
	 */
	Object getObject(String key);

	/**
	 * 写入Object，并设定存活时间 (单位: 秒)
	 * @param key 键名称 
	 * @param object 值 
	 * @param timeout 存活时间 (值大于0时限时存储，值=-1时永久存储，值=0或小于-2时不存储)
	 */
	void setObject(String key, Object object, long timeout);

	/**
	 * 更新Object (过期时间不变) 
	 * @param key 键名称 
	 * @param object 值 
	 */
	void updateObject(String key, Object object);

	/**
	 * 删除Object 
	 * @param key 键名称 
	 */
	void deleteObject(String key);
	
	/**
	 * 获取Object的剩余存活时间 (单位: 秒)
	 * @param key 指定key 
	 * @return 这个key的剩余存活时间 
	 */
	long getObjectTimeout(String key);
	
	/**
	 * 修改Object的剩余存活时间 (单位: 秒)
	 * @param key 指定key
	 * @param timeout 过期时间 
	 */
	void updateObjectTimeout(String key, long timeout);

	/**
	 * 获取Session剩余存活时间 (单位: 秒) 
	 * @param sessionId 指定Session 
	 * @return 这个Session的剩余存活时间 
	 */
	default long getSessionTimeout(String sessionId) {
		return getObjectTimeout(sessionId);
	}
	
	/**
	 * 修改Session剩余存活时间 (单位: 秒) 
	 * @param sessionId 指定Session 
	 * @param timeout 过期时间 
	 */
	default void updateSessionTimeout(String sessionId, long timeout) {
		updateObjectTimeout(sessionId, timeout);
	}
	
	
	// --------------------- 会话管理 ---------------------

	/**
	 * 搜索数据 
	 * @param prefix 前缀 
	 * @param keyword 关键字 
	 * @param start 开始处索引
	 * @param size 获取数量  (-1代表从start处一直取到末尾) 
	 * @param sortType 排序类型（true=正序，false=反序）
	 * 
	 * @return 查询到的数据集合 
	 */
	List<String> searchData(String prefix, String keyword, int start, int size, boolean sortType);
	
	
}
