package com.pisces.platform.user.controller.system;

import com.pisces.framework.web.controller.BeanController;
import com.pisces.platform.user.bean.system.UserConfig;
import com.pisces.platform.user.config.UserConstant;
import com.pisces.platform.user.service.system.UserConfigService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户配置控制器
 *
 * @author jason
 * @date 2023/07/05
 */
@RestController
@RequestMapping(UserConstant.IDENTIFY + "/UserConfig")
public class UserConfigController extends BeanController<UserConfig, UserConfigService> {
}
