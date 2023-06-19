package zbw.example.user.api;

import zbw.example.user.entity.Role;

import java.util.List;

public interface RoleService {
    public boolean save(Role role);

    public boolean deleteById(int Id);

    public Role findById(int id);

    public List<Role> findAll();
}
