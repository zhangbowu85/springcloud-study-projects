package zbw.example.microservices.composite.product.entity

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed

@RedisHash("ProductEntity")
class ProductEntity implements Serializable {

    @Id
    int productId
    @Indexed
    String name
    int weight

    String toString() {
        return "${productId} : ${name} : ${weight}"
    }

}
