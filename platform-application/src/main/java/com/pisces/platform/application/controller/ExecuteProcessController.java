package com.pisces.platform.application.controller;

import com.pisces.framework.web.controller.BeanController;
import com.pisces.platform.application.bean.ExecuteProcess;
import com.pisces.platform.application.config.PlatformConstant;
import com.pisces.platform.application.service.ExecuteProcessService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 执行过程控制器
 *
 * @author jason
 * @date 2022/12/07
 */
@RestController
@RequestMapping(PlatformConstant.IDENTIFY + "/ExecuteProcess")
public class ExecuteProcessController extends BeanController<ExecuteProcess, ExecuteProcessService> {
}
