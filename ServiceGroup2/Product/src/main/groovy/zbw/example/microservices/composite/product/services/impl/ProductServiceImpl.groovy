package zbw.example.microservices.composite.product.services.impl


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import zbw.example.microservices.composite.product.entity.ProductEntity
import zbw.example.microservices.composite.product.exceptions.ProductNotFoundException
import zbw.example.microservices.composite.product.repository.ProductRepository
import zbw.example.microservices.composite.product.services.ProductService

@Service
class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository

    @Override
    ProductEntity saveProduct(ProductEntity product) {
        System.out.println("Calling Saving ${product.toString()}")
        return productRepository.save(product)
    }

    @Override
    void deleteProduct(Integer id) {
        System.out.println("Deleting ${id}")
        ProductEntity product = productRepository.findById(id).orElseThrow(
                () -> new ProductNotFoundException("Product ${id} not found")
        )
        productRepository.deleteById(id)
    }

    @Override
    ProductEntity getOneProduct(Integer id) {
        ProductEntity product = productRepository.findById(id)
            .orElseThrow(() -> new ProductNotFoundException("Product ${id} not found"))
        return product
    }

    @Override
    List<ProductEntity> getAllProduct() {
        System.out.println("getting all products")
        List<ProductEntity> products = productRepository.findAll()
        return products
    }
}
