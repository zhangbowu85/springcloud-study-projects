package zbw.example.microservices.composite

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class CommentApplication {

    static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(CommentApplication, args)
        System.out.print("I am service: " + ctx.getEnvironment().getProperty("spring.application.name"))
    }

    @GetMapping(value= "/hello", produces = "application/json")
    String sayHello() {
        return "Hello from comment service."
    }

}
