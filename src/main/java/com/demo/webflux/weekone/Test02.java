package com.demo.webflux.weekone;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Test02 {

    @Test
    public void testTwo() {
// 1~100까지의 자연수 중 짝수만 출력하는 로직 검증
        //https://okky.kr/article/519631
        //https://altongmon.tistory.com/769

        Flux<Integer> fl = Flux.range(1, 100)
                .filter(i -> i%2 ==0).log();

        StepVerifier.create(fl)
                .thenConsumeWhile(g -> {
                    if(g%2 == 0) {
                        System.out.println(g);
                        return true;
                    }else {return false;}
                }).verifyComplete();


    }
}
