package zbw.example.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zbw.example.user.entity.Role;
import zbw.example.user.mapper.RoleMapper;
import zbw.example.user.api.RoleService;

import java.util.List;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    public boolean save(Role role) {
        return roleMapper.insert(role) == 1;
    }

    public boolean deleteById(int roleId) {
        log.info("Service: deleting role");
        return roleMapper.deleteById(roleId) == 1;
    }

    public Role findById(int roleID) {
        log.info("Service: finding role by id");
        return roleMapper.findById(roleID);
    }

    public List<Role> findAll() {
        return  roleMapper.findAll();
    }
}
