package com.example.springaop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class TimeAspect {

    @Pointcut("execution(* com.example.springaop.controller.*.*(..))")
    private void pt(){}

    @Around("pt()")
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        //执行业务逻辑代码TODO
        Object proceed = joinPoint.proceed();

        long end = System.currentTimeMillis();
        log.info(joinPoint.getSignature()+ "方法执行时间：{}ms", end - start);
        return proceed;
    }
}
