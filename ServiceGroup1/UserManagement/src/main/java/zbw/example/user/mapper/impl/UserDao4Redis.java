package zbw.example.user.mapper.impl;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;
import zbw.example.user.entity.User;
import zbw.example.user.mapper.UserDao;

import javax.annotation.Resource;
import java.util.Map;

@Repository
public class UserDao4Redis implements UserDao {

    private final String hashReference= "User";

    @Resource(name="redisTemplate")
    private HashOperations<String, Integer, User> hashOperations;

    @Override
    public void saveUser(User user) {
        hashOperations.putIfAbsent(hashReference, user.getId(), user);
    }

    @Override
    public User getOneUser(Integer id) {
        return hashOperations.get(hashReference, id);
    }

    @Override
    public Map<Integer, User> getAllUsers() {
        return hashOperations.entries(hashReference);
    }

    @Override
    public void deleteUser(Integer id) {
        hashOperations.delete(hashReference, id);
    }
}
