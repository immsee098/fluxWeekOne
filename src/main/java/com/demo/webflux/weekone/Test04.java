package com.demo.webflux.weekone;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Locale;

public class Test04 {

    @Test
    public void testFour() {
//        아래와 같은 객체가 전달될 때 “JOHN”, “JACK”등이 대문자로 변환되어 출력되는 로직 검증
//        Person(“John”, “[john@gmail.com](mailto:john@gmail.com)”, “12345678”)
//        Person(“Jack”, “[jack@gmail.com](mailto:jack@gmail.com)”, “12345678”)
//

        Person p1 = new Person("john", "[john@gmail.com](mailto:john@gmail.com)", "12345678");
        Flux<Person> flx = Flux.just(p1)
                .doOnNext(i -> {
                    String name = i.getName();
                    String bigName = name.toUpperCase();
                    Person nnPerson = i;
                    nnPerson.setName(bigName);
                    nnPerson.setMail((i.getMail()).replace(name, bigName));

                }).log();

        StepVerifier.create(flx)
                .thenConsumeWhile(i -> {
                    String upperName = i.getName().toUpperCase();
                    String lowerName = i.getName().toLowerCase();
                    if(i.getName().contains(upperName) && !i.getMail().contains(lowerName)) {
                        System.out.println(i.name);
                        System.out.println(i.mail);
                        return true;
                    } else {
                        System.out.println(i.name);
                        System.out.println(i.mail);
                        return false;
                    }
                })
                .verifyComplete();
    }


}
