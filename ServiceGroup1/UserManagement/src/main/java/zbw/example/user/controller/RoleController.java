package zbw.example.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zbw.example.user.entity.Role;
import zbw.example.user.api.RoleService;

import java.util.List;

@RestController
@RequestMapping("/role")
@Slf4j
public class RoleController {

    @Autowired(required = true)
    RoleService roleService;

    @PostMapping(value = "/add",
            consumes = "application/json")
    @ResponseBody
    public String addRole(@RequestBody Role role) {
        boolean res = roleService.save(role);
        return res ? "Succeed" : "Failed";
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public String deleteRole(@PathVariable int id) {
        log.info("You are going to delete role with id " + id);
        return roleService.deleteById(id) ? "${id} deleted" : "failed to delete role ${id}";
    }

    @GetMapping(value = "/{id}",
            produces = "application/json")
    @ResponseBody
    public Role getRole(@PathVariable int id) {
        log.info("Try to query role by id " + id);
        return roleService.findById(id);
    }

    @GetMapping(value = "/all",
            produces = "application/json")
    @ResponseBody
    public List<Role> getAllRoles() {
        return roleService.findAll();
    }

}
