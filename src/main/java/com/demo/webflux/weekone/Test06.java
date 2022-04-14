package com.demo.webflux.weekone;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Test06 {

    @Test
    public void testSix() {
//        ["google", "abc", "fb", "stackoverflow”] 의 문자열 중 5자 이상 되는 문자열만 대문자로 " +
//                "비동기로 치환하여 1번 반복하는 스트림으로 처리하는 로직 검증
//        예상되는 스트림 결과값 ["GOOGLE", "STACKOVERFLOW", "GOOGLE", "STACKOVERFLOW"]
        List<String> li = Arrays.asList("google", "abc", "fb", "stackoverflow");
        Flux fl = Flux.fromIterable(li)
                .filter(i -> i.length() >= 5)
                .flatMap(i -> Flux.just(i.toUpperCase()))
                .publishOn(Schedulers.boundedElastic())
                .repeat(1)
                .log();

        StepVerifier.create(fl)
                .expectNext("GOOGLE", "STACKOVERFLOW", "GOOGLE", "STACKOVERFLOW")
                .verifyComplete();

    }
}
