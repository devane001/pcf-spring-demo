package io.choerodon;

import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

/**
 * @author dongfan117@gmail.com
 */
//@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Welcome to reactive world ~";
    }

    @GetMapping("/hello2")
    public Mono<String> hello2() {
        return Mono.just("Welcome to reactive world ~");
    }
}
