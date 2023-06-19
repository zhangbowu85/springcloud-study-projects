package zbw.example.user.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import zbw.example.user.entity.Role;

import java.util.List;

@Mapper
public interface RoleMapper {
    @Select("select * from role")
    public List<Role> findAll();

    @Select("SELECT * FROM role WHERE id = #{id}")
    public Role findById(int id);

    @Delete("DELETE FROM role WHERE id = #{id}")
    public int deleteById(int id);

    @Insert("INSERT INTO role(role_name, role_description) VALUES (#{roleName}, #{roleDescription})")
    public int insert(Role role);
}
