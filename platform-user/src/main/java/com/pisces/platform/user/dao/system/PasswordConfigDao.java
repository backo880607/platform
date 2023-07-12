package com.pisces.platform.user.dao.system;

import com.pisces.framework.rds.common.SQLSingletonDao;
import com.pisces.platform.user.bean.system.PasswordConfig;
import org.springframework.stereotype.Component;

/**
 * 密码配置刀
 *
 * @author jason
 * @date 2023/07/09
 */
@Component
public class PasswordConfigDao extends SQLSingletonDao<PasswordConfig> {
}
