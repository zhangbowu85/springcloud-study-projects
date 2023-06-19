package zbw.example.microservices.composite.repository

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import zbw.example.microservices.composite.entity.CommentEntity

@Repository
interface CommentRepository extends CrudRepository<CommentEntity, Integer> {

    @Query(value = "Select * from comment c where c.product_id=:productId", nativeQuery = true)
    List<CommentEntity> findCommentByProductId(@Param("productId") int productId)

    @Modifying
    @Query(value = "delete from comment c where c.product_id=:productId", nativeQuery = true)
    void deleteCommentsByProductId(@Param("productId") int productId)
}
