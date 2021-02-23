package hibernate.dao;

import hibernate.model.Role;

public interface RoleDao {
    Role add(Role role);

    Role getRoleByName(String roleName);
}
