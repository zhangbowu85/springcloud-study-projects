package zbw.example.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import zbw.example.user.service.MyUserDatailService;

@Configuration
class DefaultSecurityConfig{

    @Bean
    UserDetailsService userDetailsService() {
        return new MyUserDatailService();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeHttpRequests()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated();
        http.formLogin(Customizer.withDefaults());
        http.userDetailsService(userDetailsService());
        http.httpBasic();
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
