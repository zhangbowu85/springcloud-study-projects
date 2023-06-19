package zbw.example.user.entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Role {
    private static final long serialVersionUID = 1L;

    private int id;
    private String roleName;
    private String roleDescription;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
