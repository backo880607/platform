package com.pisces.platform.user.dao.system;

import com.pisces.framework.rds.common.SQLSingletonDao;
import com.pisces.platform.user.bean.system.UserConfig;
import org.springframework.stereotype.Component;

/**
 * 用户配置刀
 *
 * @author jason
 * @date 2023/07/05
 */
@Component
public class UserConfigDao extends SQLSingletonDao<UserConfig> {
}
