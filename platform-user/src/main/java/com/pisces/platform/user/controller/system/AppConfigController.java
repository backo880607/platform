package com.pisces.platform.user.controller.system;

import com.pisces.framework.web.controller.BeanController;
import com.pisces.platform.user.bean.system.AppConfig;
import com.pisces.platform.user.config.UserConstant;
import com.pisces.platform.user.service.system.AppConfigService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 应用程序配置控制器
 *
 * @author jason
 * @date 2023/07/05
 */
@RestController
@RequestMapping(UserConstant.IDENTIFY + "/AppConfig")
public class AppConfigController extends BeanController<AppConfig, AppConfigService> {
}
