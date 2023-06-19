package zbw.example.user.mapper;

import zbw.example.user.entity.User;

import java.util.Map;

public interface UserDao {
    public void saveUser(User user);
    public User getOneUser(Integer id);
    Map<Integer, User> getAllUsers();
    void deleteUser(Integer id);
}
