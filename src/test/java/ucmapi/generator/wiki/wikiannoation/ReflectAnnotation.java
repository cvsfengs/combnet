package ucmapi.generator.wiki.wikiannoation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ycfeng on 2016/8/31.
 * 反射注解
 * 临时定义
 */
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ReflectAnnotation {
    /**
     * 属性标记名称,可为空
     */
    String val() default "";
}
