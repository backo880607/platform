package com.pisces.platform.application.controller;

import com.pisces.framework.web.controller.BeanController;
import com.pisces.platform.application.bean.ApplicationConfig;
import com.pisces.platform.application.config.ApplicationConstant;
import com.pisces.platform.application.service.ApplicationConfigService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 应用程序配置控制器
 *
 * @author jason
 * @date 2022/12/07
 */
@RestController
@RequestMapping(ApplicationConstant.IDENTIFY + "/ApplicationConfig")
public class ApplicationConfigController extends BeanController<ApplicationConfig, ApplicationConfigService> {
}
