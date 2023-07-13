package com.pisces.platform.application.query;

import lombok.Data;

import java.util.List;

/**
 * 网格请求
 *
 * @author Jason
 * @date 2022-03-18
 */
@Data
public class GridRequest {
    private String tableName;
    private Integer startRow;
    private Integer endRow;
    private List<GridFilterGroup> filterModel;
    private List<GridSortModel> sortModel;
}
