package com.pisces.platform.application.query;

import com.pisces.framework.core.enums.VALUE_SORT_TYYPE;
import lombok.Data;

/**
 * 排序信息
 *
 * @author Jason
 * @date 2022-03-18
 */
@Data
public class GridSortModel {
    private String column;
    private VALUE_SORT_TYYPE sort;
}
