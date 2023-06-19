package zbw.example.microservices.composite.product.controller


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import zbw.example.microservices.composite.product.entity.ProductEntity
import zbw.example.microservices.composite.product.services.ProductService

@RestController
@RequestMapping("/product")
@ResponseBody
class ProductController {

    @Autowired
    ProductService productService


    @GetMapping(value = "/hello", produces = "application/json")
    Iterable<ProductEntity> getAll() {
        System.out.println("You are Calling me.")
        return [].tap {
            it.add(new ProductEntity().tap {ProductEntity p ->
                p.productId = 1
                p.name = "book"
                p.weight = 100
            })
            it.add(new ProductEntity().tap {ProductEntity p ->
                p.productId = 2
                p.name = "book2"
                p.weight = 105
            })
        }
    }

    @PostMapping(path = "/add", consumes = "application/json")
    public ProductEntity saveProduct(@RequestBody ProductEntity product) {
        System.out.println("Calling saving ")
        return productService.saveProduct(product)
    }

    @GetMapping("/all")
    List<ProductEntity> getAllProduct() {
        System.out.print("Calling /product/all")
        return productService.getAllProduct()
    }

    @GetMapping("/{id}")
    public ProductEntity getProduct(@PathVariable Integer id) {
        return productService.getOneProduct(id)
    }

    @DeleteMapping("/{id}")
    String deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id)
        return "Product with id ${id} has been deleted!"
    }
}
