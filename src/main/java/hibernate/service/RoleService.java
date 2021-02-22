package hibernate.service;

import hibernate.model.Role;

public interface RoleService {
    void add(Role role);

    Role getRoleByName(String roleName);
}
