package com.pisces.platform.user.controller.dataset;

import com.pisces.framework.web.controller.BeanController;
import com.pisces.platform.user.bean.dataset.DataSetAccount;
import com.pisces.platform.user.config.UserConstant;
import com.pisces.platform.user.service.dataset.DataSetAccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据集帐户控制器
 *
 * @author jason
 * @date 2022/12/07
 */
@RestController
@RequestMapping(UserConstant.IDENTIFY + "/DataSetAccount")
class DataSetAccountController extends BeanController<DataSetAccount, DataSetAccountService> {
}
