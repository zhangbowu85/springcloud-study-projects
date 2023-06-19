package zbw.example

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.config.server.EnableConfigServer
import org.springframework.context.ConfigurableApplicationContext

@EnableConfigServer
@SpringBootApplication
class ConfigServerApplication {

    static void main (String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ConfigServerApplication.class, args);

        String repoLocation = ctx.getEnvironment().getProperty("spring.cloud.config.server.native.searchLocations")
        System.out.println("Configuration Repository location is: ${repoLocation}")
    }
}
