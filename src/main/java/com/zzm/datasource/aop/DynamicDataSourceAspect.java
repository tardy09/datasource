package com.zzm.datasource.aop;

import com.alibaba.fastjson.JSON;
import com.zzm.datasource.utils.ForMatJSONStr;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>@Author: james</p>
 * <p>@Description: 添加说明</P>
 * <p>@Date: 创建日期 2018/10/24 9:55</P>
 * <p>@version V1.0</p>
 **/
@Aspect
@Component
@Slf4j
public class DynamicDataSourceAspect {

    @Pointcut("execution(public * com.zzm.datasource.controller.*.*(..)))")
    public void valid() {}

    /**
     * 前置通知
     */
    @Before("valid()")
    public void doBefore(JoinPoint joinPoint) {

        log.info("<=========================================开始请求====================================>");

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attributes.getRequest();

        //url
        log.info("[请\t\t求\t路\t径]{}", "["+request.getRequestURL()+"]");

        //method
        log.info("[请\t\t求\t方\t法]{}", "["+request.getMethod()+"]");

        //ip
        log.info("[远\t\t程\t地\t址]{}", "["+request.getRemoteAddr()+"]");

        //类方法
        log.info("[请\t\t求\t方\t法]{}", "["+joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()+"]");

        String str = joinPoint.getArgs().toString();
        //参数
        log.info("[参\t\t数\t类\t型]{}", "["+str.substring(str.lastIndexOf(".")+1,str.lastIndexOf(";"))+"]");
    }

    /**
     * 后置通知
     */
    @After("valid()")
    public void doAfter() {
        log.info("<=========================================结束请求====================================>");
    }

    /**
     * 通知后返回的数据
     * @param object
     */
    @AfterReturning(returning = "object", pointcut = "valid()")
    public void doAfterReturning(Object object) {
        try{
            log.info("[返\t\t回\t参\t数]\n{}", ForMatJSONStr.format(JSON.toJSONString(object)));
        }catch (NullPointerException e){
            log.info("[异\t\t常\t信\t息]{}","["+e.getMessage()+"]");
        }
    }
}
