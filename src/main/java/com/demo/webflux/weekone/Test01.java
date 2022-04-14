package com.demo.webflux.weekone;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Test01 {

    @Test
    public void testOne() {
// ["Blenders", "Old", "Johnnie"]와 ["Pride", "Monk", "Walker"] 를 순서대로
// 하나의 스트림으로 처리되는 로직 검증
        Flux names1 = Flux.just("Blenders", "Old", "Johnnie");
        Flux names2 = Flux.just("Pride", "Monk", "Walker");
        Flux name = Flux.concat(names1, names2).log();

        StepVerifier.create(name)
                .expectSubscription()
                .expectNext("Blenders", "Old", "Johnnie", "Pride", "Monk", "Walker")
                .verifyComplete();

    }
}
