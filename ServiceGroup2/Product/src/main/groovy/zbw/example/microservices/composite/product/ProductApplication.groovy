package zbw.example.microservices.composite.product

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.ConfigurableApplicationContext

@SpringBootApplication
class ProductApplication {

    static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ProductApplication, args)
        System.out.print("I am service: " + ctx.getEnvironment().getProperty("spring.application.name"))
    }

}
