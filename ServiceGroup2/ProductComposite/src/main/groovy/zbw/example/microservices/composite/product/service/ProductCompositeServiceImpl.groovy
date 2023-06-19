package zbw.example.microservices.composite.product.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
class ProductCompositeServiceImpl {

    @Autowired
    RestTemplate restTemplate

    @GetMapping(value = "/product/all", produces = "application/json")
    String getAll() {
        System.out.print("##You are calling me")
        String response = restTemplate.getForEntity("http://product/product/all", String.class)
        return response ?.length() > 0 ? response : "Did not find products"

    }

    @GetMapping(value = "/public/hello", produces = "application/json")
    String publicApi() {
        System.out.print("##You are calling me - public hello")
        return "You are calling me - public hello without token"
    }


}
