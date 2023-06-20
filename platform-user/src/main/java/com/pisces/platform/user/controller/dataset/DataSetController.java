package com.pisces.platform.user.controller.dataset;

import com.pisces.framework.web.annotation.ExceptionMessage;
import com.pisces.framework.web.controller.BeanController;
import com.pisces.framework.web.controller.ResponseData;
import com.pisces.platform.user.bean.dataset.DataSet;
import com.pisces.platform.user.config.UserConstant;
import com.pisces.platform.user.config.UserMessage;
import com.pisces.platform.user.service.dataset.DataSetService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据集控制器
 *
 * @author jason
 * @date 2022/12/07
 */
@RestController
@RequestMapping(UserConstant.IDENTIFY + "/DataSet")
class DataSetController extends BeanController<DataSet, DataSetService> {
    @RequestMapping("register")
    @ExceptionMessage(clazz = UserMessage.class, name = "REGISTER")
    public ResponseData register(DataSet dataSet) {
        getService().register(dataSet);
        return success();
    }

    @RequestMapping("unregister")
    @ExceptionMessage(clazz = UserMessage.class, name = "UNREGISTER")
    public ResponseData unregister(DataSet dataSet) {
        getService().unregister(dataSet);
        return success();
    }
}
