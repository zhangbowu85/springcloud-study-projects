package zbw.example.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import zbw.example.user.mapper.impl.UserDao4Redis;

@Service
public class MyUserDatailService implements UserDetailsService  {

    @Autowired(required = false)
    PasswordEncoder passwordEncoder;

    @Autowired
    UserDao4Redis userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username.equals("admin")) {
            return User.withUsername("admin").password("1234").roles("ADMIN").build();
        } else {
            //TO do. find from redis
            //zbw.example.user.entity.User userEntity = userDao.
            return null;
        }
    }
}
