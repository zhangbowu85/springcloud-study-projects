package zbw.example.microservices.composite.services.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import zbw.example.microservices.composite.entity.CommentEntity
import zbw.example.microservices.composite.repository.CommentRepository
import zbw.example.microservices.composite.services.CommentService

import javax.transaction.Transactional

@Service
class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository

    @Override
    List<CommentEntity> saveComments(List<CommentEntity> comments) {
        commentRepository.saveAll(comments)
        comments
    }

    @Override
    @Transactional
    void deleteProductComments(Integer productId) {
        commentRepository.deleteCommentsByProductId(productId)
        true
    }

    @Override
    List<CommentEntity> findCommentsByProductId(Integer productId) {
        return commentRepository.findCommentByProductId(productId)
    }
}
