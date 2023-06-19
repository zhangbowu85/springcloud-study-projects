package zbw.example.microservices.composite.product.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class ProductNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L

    public ProductNotFoundException(String message) {
        super(message)
    }
}
