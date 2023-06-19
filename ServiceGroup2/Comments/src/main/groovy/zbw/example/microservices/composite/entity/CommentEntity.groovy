package zbw.example.microservices.composite.entity

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Table

@Data
@Table(name = "comment")
@Entity
@AllArgsConstructor
@NoArgsConstructor
class CommentEntity {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id

    int productId
    String commentor
    String comment

    String toString() {
        return "${productId} : ${commentor} : ${comment}"
    }

}
