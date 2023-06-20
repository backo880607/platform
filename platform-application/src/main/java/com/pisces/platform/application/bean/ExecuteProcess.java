package com.pisces.platform.application.bean;

import com.pisces.framework.core.annotation.PropertyMeta;
import com.pisces.framework.core.entity.BeanObject;
import lombok.Getter;
import lombok.Setter;

/**
 * 执行进度
 *
 * @author Jason
 * @date 2022-04-04
 */
@Getter
@Setter
public class ExecuteProcess extends BeanObject {
    private String mainMessage;
    private Integer mainRow;
    private Integer mainTotalRows;
    private Integer row;
    private Integer totalRows;
    private String message;
    private Boolean finish;
    private String exception;
    @PropertyMeta(large = true)
    private String error;

    @Override
    public void init() {
        super.init();
        reset();
    }

    public void reset() {
        mainMessage = "";
        mainRow = 0;
        mainTotalRows = 0;
        row = 0;
        totalRows = 0;
        message = "";
        finish = false;
        exception = "";
        error = "";
    }
}
