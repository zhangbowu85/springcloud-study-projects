package zbw.example.microservices.composite.product.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import zbw.example.microservices.composite.product.entity.ProductEntity

@Repository
interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
}
