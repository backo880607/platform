package com.pisces.platform.application.query;

import com.pisces.framework.core.enums.CONDITION_TYPE;
import com.pisces.framework.core.query.condition.QueryConnector;
import lombok.Data;

/**
 * 筛选信息
 *
 * @author Jason
 * @date 2022-03-18
 */
@Data
public class GridFilterModel {
    private String column;
    private CONDITION_TYPE type;
    private String value;
    private QueryConnector connector = QueryConnector.AND;
}
