package zbw.example.user.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@Controller
public class HelloService {

    @GetMapping(path = "/hello")
    public String loadMainPage() {
        return "Hello, Your Spring Cloud world!";
    }
}
