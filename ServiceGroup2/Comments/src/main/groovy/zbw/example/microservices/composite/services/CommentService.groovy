package zbw.example.microservices.composite.services

import zbw.example.microservices.composite.entity.CommentEntity


interface CommentService {

    List<CommentEntity> saveComments(List<CommentEntity> comments)
    void deleteProductComments(Integer productId)
    List<CommentEntity> findCommentsByProductId(Integer productId)


}