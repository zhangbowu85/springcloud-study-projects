package zbw.example.auth.service

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthenticationService {

    @PostMapping(value = "/api/auth")
    String authenticate() {

    }
}
