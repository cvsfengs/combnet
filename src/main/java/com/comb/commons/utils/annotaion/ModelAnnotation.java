package com.comb.commons.utils.annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ycfeng on 2016/7/29.
 * 模型注解
 */
@Target({ElementType.FIELD, ElementType.METHOD,ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ModelAnnotation {
    //注解于类上,用于描述
    String modelVal() default "" ;
    //注解于属性上,用于描述
    String paramVal() default "" ;

}
