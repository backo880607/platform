package com.pisces.platform.application.service.impl;

import com.pisces.framework.core.service.BeanServiceImpl;
import com.pisces.platform.application.bean.ExecuteProcess;
import com.pisces.platform.application.dao.ExecuteProcessDao;
import com.pisces.platform.application.service.ExecuteProcessService;
import org.springframework.stereotype.Service;

/**
 * 执行过程服务impl
 *
 * @author jason
 * @date 2022/12/07
 */
@Service
public class ExecuteProcessServiceImpl extends BeanServiceImpl<ExecuteProcess, ExecuteProcessDao> implements ExecuteProcessService {
}
