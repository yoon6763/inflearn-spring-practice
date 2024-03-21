package hello.proxy.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

@Slf4j
class ReflectionTest {

    @Test
    void reflection0() {
        Hello target = new Hello();

        // 공통로직 1 시작
        log.info("start");
        String result1 = target.callA();
        log.info("result1: {}", result1);
        // 공통로직 1 종료

        // 공통로직 2 시작
        log.info("start");
        String result2 = target.callB();
        log.info("result2: {}", result2);
        // 공통로직 2 종료
    }

    @Test
    void reflection1() throws Exception {
        // 클래스 정보
        Class<?> classHello = Class.forName("hello.proxy.jdkdynamic.ReflectionTest$Hello");

        Hello target = new Hello();
        // callA의 메서드 정보
        Method methodCallA = classHello.getMethod("callA");
        dynamicCall(methodCallA, target);

        // callB의 메서드 정보
        Method methodCallB = classHello.getMethod("callB");
        Object result2 = methodCallB.invoke(target);
        log.info("result2: {}", result2);
    }

    @Test
    void reflection2() throws Exception {
        // 클래스 정보
        Class<?> classHello = Class.forName("hello.proxy.jdkdynamic.ReflectionTest$Hello");

        Hello target = new Hello();
        // callA의 메서드 정보
        Method methodCallA = classHello.getMethod("callA");
        Object result1 = methodCallA.invoke(target);
        log.info("result1: {}", result1);

        // callB의 메서드 정보
        Method methodCallB = classHello.getMethod("callB");
        Object result2 = methodCallB.invoke(target);
        log.info("result2: {}", result2);
    }

    private void dynamicCall(Method method, Object target) throws Exception {
        log.info("start");
        Object result = method.invoke(target);
        log.info("result: {}", result);
    }

    @Slf4j
    static class Hello {
        public String callA() {
            log.info("call A");
            return "A";
        }

        public String callB() {
            log.info("call B");
            return "B";
        }
    }

}
