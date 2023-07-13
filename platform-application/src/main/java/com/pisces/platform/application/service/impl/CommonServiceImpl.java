package com.pisces.platform.application.service.impl;

import com.pisces.framework.core.entity.BeanObject;
import com.pisces.framework.core.entity.Property;
import com.pisces.framework.core.exception.ExistedException;
import com.pisces.framework.core.query.QueryOrderBy;
import com.pisces.framework.core.query.QueryWrapper;
import com.pisces.framework.core.query.column.QueryColumn;
import com.pisces.framework.core.query.condition.QueryCondition;
import com.pisces.framework.core.query.condition.QueryConnector;
import com.pisces.framework.core.service.BaseServiceImpl;
import com.pisces.framework.core.service.PropertyService;
import com.pisces.framework.core.service.ServiceManager;
import com.pisces.framework.core.utils.lang.CollectionUtils;
import com.pisces.framework.core.utils.lang.ObjectUtils;
import com.pisces.framework.core.utils.lang.StringUtils;
import com.pisces.framework.web.config.WebMessage;
import com.pisces.platform.application.query.*;
import com.pisces.platform.application.service.CommonService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 公共服务impl
 *
 * @author jason
 * @date 2023/07/13
 */
@Service
public class CommonServiceImpl extends BaseServiceImpl implements CommonService {
    @Resource
    private PropertyService propertyService;

    @Override
    public GridResponse query(GridRequest request) {
        if (StringUtils.isEmpty(request.getTableName())) {
            throw new ExistedException(WebMessage.Query);
        }
        Class<? extends BeanObject> beanClass = ObjectUtils.fetchBeanClass(request.getTableName());
        if (beanClass == null) {
            throw new ExistedException(WebMessage.Query);
        }

        QueryWrapper qw = obtainQueryWrapper(beanClass, request.getFilterModel(), request.getSortModel());
        qw.offset(request.getStartRow()).limit(request.getEndRow() - request.getStartRow());
        List<? extends BeanObject> beans = ServiceManager.fetchService(beanClass).getBaseDao().fetch(qw);
        GridResponse response = new GridResponse();
        response.setBeans(beans);
        return response;
    }

    private QueryWrapper obtainQueryWrapper(Class<? extends BeanObject> beanClass, List<GridFilterGroup> filterGroups, List<GridSortModel> sortModel) {
        QueryWrapper qw = QueryWrapper.from(beanClass);
        QueryConnector groupConnector = null;
        for (GridFilterGroup filterGroup : filterGroups) {
            if (CollectionUtils.isEmpty(filterGroup.getFilters())) {
                continue;
            }
            QueryCondition condition = null;
            QueryConnector connector = null;
            for (GridFilterModel filterModel : filterGroup.getFilters()) {
                Property property = propertyService.get(beanClass, filterModel.getColumn());
                QueryColumn queryColumn = QueryColumn.getQueryColumn(property);
                if (queryColumn == null) {
                    continue;
                }
                QueryCondition childCondition = QueryCondition.create(queryColumn, filterModel.getType(), filterModel.getValue());

                if (condition != null) {
                    condition.connect(childCondition, connector);
                } else {
                    condition = childCondition;
                }
                connector = filterModel.getConnector();
            }
            qw.addWhereQueryCondition(condition, groupConnector);
            groupConnector = filterGroup.getConnector();
        }
        for (GridSortModel model : sortModel) {
            Property property = propertyService.get(beanClass, model.getColumn());
            QueryColumn queryColumn = QueryColumn.getQueryColumn(property);
            if (queryColumn == null) {
                continue;
            }

            qw.orderBy(new QueryOrderBy(queryColumn, model.getSort()));
        }
        return qw;
    }
}
