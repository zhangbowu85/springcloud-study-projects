package zbw.example.user.service

import lombok.AllArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
@AllArgsConstructor
class CustomUserDetailService implements UserDetailsService {
    @Autowired
    PasswordEncoder passwordEncoder

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.print("You are calling me")
        return User.withUsername(username)
                .password(passwordEncoder.encode('1234')).authorities('user').build()
    }
}
