package com.workorder.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class AspectDome {
    @Pointcut("execution(public * com.workorder.controller.*.*(..))")
    public void AspectPointcut(){

    }
    @Around("AspectPointcut()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        try {
            String name = point.getTarget().getClass().getName();
            String methodName = point.getSignature().getName();
            Class<?> aClass = Class.forName(name);
            Method[] methods = aClass.getMethods();
            boolean value = true;
            for (Method item : methods){
                if(item.getName().equals(methodName)){
                    Dome annotation = item.getAnnotation(Dome.class);
                    if(annotation != null){
                        value = annotation.value();
                        break;
                    }
                }
            }
            System.out.println(value);

            System.out.println("前置");
            Object proceed = point.proceed();
            System.out.println("后置");
        }catch (Throwable throwable){
            System.out.println("异常通知");
        }
        return point.proceed();
    }
}
