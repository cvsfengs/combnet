package com.comb.commons.dynamic;

import com.comb.commons.dynamic.enums.DataSourceEunm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DataSource {
    /**
     * 默认写库
     */
    DataSourceEunm dataId() default DataSourceEunm.W;
}
