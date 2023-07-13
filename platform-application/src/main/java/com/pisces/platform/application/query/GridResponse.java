package com.pisces.platform.application.query;

import com.pisces.framework.core.entity.BeanObject;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 网格反应
 *
 * @author Jason
 * @date 2022-03-18
 */
@Data
public class GridResponse {
    private Integer totalRow = 0;
    private List<? extends BeanObject> beans = new ArrayList<>();
}
