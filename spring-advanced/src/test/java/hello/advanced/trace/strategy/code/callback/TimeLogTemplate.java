package hello.advanced.trace.strategy.code.callback;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeLogTemplate {

    public void execute(Callback callback) {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        callback.call(); // 위임
        // 비즈니스 로직 종료
        long endTIme = System.currentTimeMillis();
        long resultTime = endTIme - startTime;
        log.info("resultTime={}", resultTime);
    }

}
