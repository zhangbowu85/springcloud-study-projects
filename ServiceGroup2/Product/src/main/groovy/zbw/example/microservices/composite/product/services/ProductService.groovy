package zbw.example.microservices.composite.product.services

import zbw.example.microservices.composite.product.entity.ProductEntity


interface ProductService {

    ProductEntity saveProduct(ProductEntity product)
    void deleteProduct(Integer id)
    ProductEntity getOneProduct(Integer id)
    List<ProductEntity> getAllProduct()


}