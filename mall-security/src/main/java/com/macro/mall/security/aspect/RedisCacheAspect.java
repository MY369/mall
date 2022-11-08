package com.macro.mall.security.aspect;

import com.macro.mall.security.annotation.CacheException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Redis缓存切面，防止Redis宕机影响正常业务逻辑
 * 织入到各种的 缓存操作 周围, 包上trycatch, 然后出错捕获出个日志. 验证码缓存业务不能捕获, 要再抛出来.
 *   总结就是: 对于影响性能的，频繁查询数据库的操作，我们可以通过Redis作为缓存来优化。缓存操作不该影响正常业务逻辑，我们可以使用AOP来统一处理缓存操作中的异常。
 * Created by macro on 2020/3/17.
 */
@Aspect
@Component
@Order(2)
public class RedisCacheAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisCacheAspect.class);

    @Pointcut("execution(public * com.macro.mall.portal.service.*CacheService.*(..)) || execution(public * com.macro.mall.service.*CacheService.*(..))")
    public void cacheAspect() {
    }

    @Around("cacheAspect()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            //有CacheException注解的方法需要抛出异常, 比如验证码业务, 查不到验证码就不能继续了
            if (method.isAnnotationPresent(CacheException.class)) {
                throw throwable;
            } else {
                //其他的就算出问题, 可以继续去数据库里面查询 , 所以出个日志就行了
                LOGGER.error(throwable.getMessage());
            }
        }
        return result;
    }

}
