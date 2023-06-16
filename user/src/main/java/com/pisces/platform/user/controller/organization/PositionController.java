package com.pisces.platform.user.controller.organization;

import com.pisces.framework.web.controller.BaseController;
import com.pisces.platform.user.bean.organization.Position;
import com.pisces.platform.user.config.UserConstant;
import com.pisces.platform.user.service.organization.PositionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 位置控制器
 *
 * @author jason
 * @date 2022/12/07
 */
@RestController
@RequestMapping(UserConstant.IDENTIFY + "/Position")
class PositionController extends BaseController<Position, PositionService> {
}
