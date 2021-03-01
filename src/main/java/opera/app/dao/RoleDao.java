package opera.app.dao;

import opera.app.model.Role;

public interface RoleDao {
    Role add(Role role);

    Role getRoleByName(String roleName);
}
