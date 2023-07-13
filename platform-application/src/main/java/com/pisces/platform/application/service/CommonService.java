package com.pisces.platform.application.service;

import com.pisces.framework.core.service.BaseService;
import com.pisces.platform.application.query.GridRequest;
import com.pisces.platform.application.query.GridResponse;

/**
 * 公共服务
 *
 * @author jason
 * @date 2023/07/13
 */
public interface CommonService extends BaseService {
    GridResponse query(GridRequest request);
}
