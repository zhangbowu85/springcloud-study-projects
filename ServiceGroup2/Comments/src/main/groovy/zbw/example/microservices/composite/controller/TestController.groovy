package zbw.example.microservices.composite.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    @GetMapping(value = "/test/hello")
    String testHello() {
        return " you are calling /test/hello"
    }
}
