package com.zzm.datasource.annotation;

import java.lang.annotation.*;

/**
 * <p>@Author: james</p>
 * <p>@Date: 创建日期 2018/10/24 9:50</P>
 * <p>@version V1.0</p>
 * <p>@Description: 切换数据注解 可以用于类或者方法级别 方法级别优先级 > 类级别</P>
 **/

@Target({ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: java.lang.String</P>
     * <p>@date: 2018/10/24 9:52</P>
     * <p>@description: 默认指向master这个数据库</p>
     */
    String value() default "master";

}
