package com.comb.commons.dynamic.datasource;

import com.comb.commons.dynamic.handler.DataSourceHandler;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 */
public class AynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceHandler.getDbType();
    }
}
