package hello.proxy.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class TimeAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("TimeAdvice 실행");

        long start = System.currentTimeMillis();
        Object result = invocation.proceed();

        long end = System.currentTimeMillis();
        long resultTime = end - start;
        log.info("TimeAdvice 종료 : {}", resultTime);
        return result;
    }

}
