package com.wenbobi.springmvc_demo2.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class TimeAspect {

    @Around("execution(* com.wenbobi.springmvc_demo2.controller.*.*(..))")
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        //执行业务逻辑代码TODO
        Object proceed = joinPoint.proceed();

        long end = System.currentTimeMillis();
        log.info(joinPoint.getSignature()+ "方法执行时间：{}ms", end - start);
        return proceed;
    }
}
