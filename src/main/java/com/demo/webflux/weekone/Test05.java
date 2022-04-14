package com.demo.webflux.weekone;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test05 {

    @Test
    public void testFive() {
//     ["Blenders", "Old", "Johnnie"]와 ["Pride", "Monk", "Walker"] 를 압축하여 스트림으로 처리 검증
//["Blenders Pride", "Old Monk", "Johnnie Walker"]
        List<String> a1 = Arrays.asList("Blenders", "Old", "Johnnie");
        List<String> a2 = Arrays.asList("Pride", "Monk", "Walker");
        Flux<String> fl1 = Flux.fromIterable(a1);
        Flux<String> fl2 = Flux.fromIterable(a2);
        Flux fl = Flux.zip(fl1, fl2, (a, b)-> a+ " "+ b).log();

        StepVerifier.create(fl)
                .expectNext("Blenders Pride", "Old Monk", "Johnnie Walker")
                .verifyComplete();

    }
}
