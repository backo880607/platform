package com.pisces.platform.application.query;

import com.pisces.framework.core.query.condition.QueryConnector;
import lombok.Data;

import java.util.List;

/**
 * 电网滤波器组
 *
 * @author jason
 * @date 2023/07/13
 */
@Data
public class GridFilterGroup {
    private List<GridFilterModel> filters;
    private QueryConnector connector;
}
