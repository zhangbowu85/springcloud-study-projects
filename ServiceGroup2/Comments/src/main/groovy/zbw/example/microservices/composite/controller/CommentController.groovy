package zbw.example.microservices.composite.controller


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import zbw.example.microservices.composite.entity.CommentEntity
import zbw.example.microservices.composite.services.CommentService

@RestController
@RequestMapping("comment")
class CommentController {

    @Autowired
    CommentService commentService

    @GetMapping(value = "/hello", produces = "application/json")
    Iterable<CommentEntity> getAll() {
        System.out.println("You are Calling me.")
        return [].tap {
            it.add(new CommentEntity().tap {CommentEntity p ->
                p.id = 1
                p.productId = 1
                p.commentor = "zhangsan"
                p.comment = "very good"
            })
            it.add(new CommentEntity().tap {CommentEntity p ->
                p.id = 2
                p.productId = 1
                p.commentor = "Lisi"
                p.comment = "very bad"
            })
        }
    }

    @PostMapping(path = "/add", consumes = "application/json")
    public List<CommentEntity> saveComments(@RequestBody List<CommentEntity> comments) {
        System.out.println("Calling saving ")
        return commentService.saveComments(comments)
    }

    @GetMapping("/all/{productId}")
    List<CommentEntity> getAllProduct(@PathVariable int productId) {
        System.out.print("Calling /comment/all")
        return commentService.findCommentsByProductId(productId)
    }


    @DeleteMapping("/{productId}")
    String deleteCommentsByProductId(@PathVariable Integer productId) {
        commentService.deleteProductComments(productId)
        return "comments for with product ${productId} has been deleted!"
    }
}
