package com.demo.webflux.weekone;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

public class Test04 {

    @Test
    public void testFour() {
//        아래와 같은 객체가 전달될 때 “JOHN”, “JACK”등이 대문자로 변환되어 출력되는 로직 검증
//        Person(“John”, “[john@gmail.com](mailto:john@gmail.com)”, “12345678”)
//        Person(“Jack”, “[jack@gmail.com](mailto:jack@gmail.com)”, “12345678”)
// 0번을 케이스로 잡아 그 부분만 교체;

        Person p1 = new Person("John", "[john@gmail.com](mailto:john@gmail.com)", "12345678");
        Flux<Person> flx = Flux.just(p1).log();
    }


}
