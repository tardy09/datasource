package com.zzm.datasource.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * <p>@Author: james</p>
 * <p>@Description: 添加说明</P>
 * <p>@Date: 创建日期 2018/10/24 9:57</P>
 * <p>@version V1.0</p>
 **/
@Slf4j
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {


    @Override
    protected Object determineCurrentLookupKey() {
        String dataSourceName = DynamicDataSourceContextHolder.getDataSourceRouterKey();
        log.info("当前数据源是：{}", dataSourceName);
        return DynamicDataSourceContextHolder.getDataSourceRouterKey();
    }

}
