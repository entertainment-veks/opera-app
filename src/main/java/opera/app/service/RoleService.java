package opera.app.service;

import opera.app.model.Role;

public interface RoleService {
    void add(Role role);

    Role getRoleByName(String roleName);
}
