package opera.app.controller;

import opera.app.model.Role;
import opera.app.model.User;
import opera.app.service.RoleService;
import opera.app.service.UserService;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
public class DataInitializer {
    private UserService userService;
    private RoleService roleService;

    @Autowired
    public DataInitializer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostMapping
    public void injectData() {
        User coolBob = new User();
        coolBob.setEmail("im_cool_boy@gmail.com");
        coolBob.setPassword("im_the_best");
        Role adminRole = new Role();
        adminRole.setRoleName(Role.RoleName.ADMIN);
        roleService.add(adminRole);
        coolBob.setRoles(Set.of(adminRole));
        userService.add(coolBob);

        User commonAlice = new User();
        commonAlice.setEmail("alice_bobson@gmail.com");
        commonAlice.setPassword("alicok");
        Role userRole = new Role();
        userRole.setRoleName(Role.RoleName.USER);
        roleService.add(userRole);
        commonAlice.setRoles(Set.of(userRole));
        userService.add(commonAlice);
    }
}
