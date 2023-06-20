package com.pisces.platform.workflow.config;

import com.pisces.framework.core.config.BaseProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 语言属性
 *
 * @author jason
 * @date 2022/12/07
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "pisces.platform.workflow")
public class WorkflowProperties extends BaseProperties {
    public WorkflowProperties() {
        super(WorkflowConstant.IDENTIFY);
    }
}
