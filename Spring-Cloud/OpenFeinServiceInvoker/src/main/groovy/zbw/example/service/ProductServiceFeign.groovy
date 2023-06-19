package zbw.example.service

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(value = "product")
interface ProductServiceFeign {
    @RequestMapping(value = "/product/hello", method = RequestMethod.GET)
    String queryProductFromClient();
}