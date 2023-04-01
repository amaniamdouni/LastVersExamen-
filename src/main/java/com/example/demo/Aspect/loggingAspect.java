package com.example.demo.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class loggingAspect {
    @AfterReturning("execution(Iterable<Object> com.example.demo.Service.get*(..))")

    public void logOutOfMethod (JoinPoint joinPoint)
    {
        log.info("out od method "+joinPoint.getSignature().getName());
    }
}
