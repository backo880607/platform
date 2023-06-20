package com.pisces.platform.user.service.organization.impl;

import com.pisces.framework.core.service.BeanServiceImpl;
import com.pisces.platform.user.bean.organization.Position;
import com.pisces.platform.user.dao.organization.PositionDao;
import com.pisces.platform.user.service.organization.PositionService;
import org.springframework.stereotype.Service;

/**
 * 位置服务impl
 *
 * @author jason
 * @date 2022/12/07
 */
@Service
class PositionServiceImpl extends BeanServiceImpl<Position, PositionDao> implements PositionService {
}
