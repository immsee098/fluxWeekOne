package com.demo.webflux.weekone;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.time.Duration;

public class Test03 {

    @Test
    public void testThree() {
// "hello", "there"를 순차적으로 publish 하여 순서대로 나오는지 검증
        Flux<String> fl1 = Flux.just("hello", "there")
                .publishOn(Schedulers.single()).log()
                .delayElements(Duration.ofMillis(100));


        StepVerifier.create(fl1)
                .expectNext("hello")
                .expectNext("there")
                .verifyComplete();

    }
}
