package zbw.example.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import zbw.example.service.ProductServiceFeign

@RestController
class ProductServiceController {

    @Autowired
    ProductServiceFeign productServiceFeign

    @GetMapping(value = "/product/hello")
    String queryAllProduct() {
        return productServiceFeign.queryProductFromClient()
    }
}
