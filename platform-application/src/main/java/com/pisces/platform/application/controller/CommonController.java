package com.pisces.platform.application.controller;

import com.pisces.framework.web.annotation.ExceptionMessage;
import com.pisces.framework.web.config.WebMessage;
import com.pisces.framework.web.controller.BaseController;
import com.pisces.framework.web.controller.ResponseData;
import com.pisces.platform.application.config.PlatformConstant;
import com.pisces.platform.application.query.GridRequest;
import com.pisces.platform.application.service.CommonService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 常见控制器
 *
 * @author jason
 * @date 2023/07/13
 */
@RestController
@RequestMapping(PlatformConstant.IDENTIFY + "/common")
public class CommonController extends BaseController {
    @Resource
    private CommonService commonService;

    @PostMapping(value = "query")
    @ExceptionMessage(clazz = WebMessage.class, name = "Query")
    public ResponseData query(@RequestBody GridRequest request) {
        return success(commonService.query(request), WebMessage.Query);
    }
}
