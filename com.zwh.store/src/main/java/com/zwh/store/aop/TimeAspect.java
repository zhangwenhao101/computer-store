package com.zwh.store.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author zwh
 */
@Component//将当前类交给spring容器维护
@Aspect//标记为切面类
public class TimeAspect {

    @Around("execution(* com.zwh.store.service.impl.*.*(..))")
    /**
     * @param pjp 目标方法的对象
     * @return
     */
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();//调用目标方法
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
        return result;
    }
}
