package com.pisces.platform.user.controller.system;

import com.pisces.framework.web.controller.BeanController;
import com.pisces.platform.user.bean.system.PasswordConfig;
import com.pisces.platform.user.config.UserConstant;
import com.pisces.platform.user.service.system.PasswordConfigService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 密码配置控制器
 *
 * @author jason
 * @date 2023/07/09
 */
@RestController
@RequestMapping(UserConstant.IDENTIFY + "/PasswordConfig")
public class PasswordConfigController extends BeanController<PasswordConfig, PasswordConfigService> {
}
