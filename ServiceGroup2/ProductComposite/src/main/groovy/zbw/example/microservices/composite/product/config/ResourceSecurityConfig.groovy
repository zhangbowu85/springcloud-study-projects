package zbw.example.microservices.composite.product.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
class ResourceSecurityConfig {

    @Value('${app.auth-server.uri}')
    private String authServerUri

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) {

        http.authorizeHttpRequests()
                .antMatchers("/public/**").permitAll()
                .antMatchers("/product/**").hasAuthority("SCOPE_ALL")
                .anyRequest().authenticated()
        http.oauth2ResourceServer(r -> r
            .jwt().jwkSetUri("http://localhost:18080/oauth2/jwks"))

        return http.build()
    }

}
