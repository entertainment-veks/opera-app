package hibernate.controller;

import hibernate.model.Movie;
import hibernate.model.Role;
import hibernate.model.Role.RoleName;
import hibernate.model.User;
import hibernate.model.dto.MovieRequestDto;
import hibernate.service.RoleService;
import hibernate.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import static hibernate.model.Role.RoleName.ADMIN;
import static hibernate.model.Role.RoleName.USER;

@RestController
@RequestMapping("/inject-data")
public class InjectDataController {
    UserService userService;
    RoleService roleService;

    @Autowired
    public InjectDataController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostMapping
    public void injectData() {
        User coolBob = new User();
        coolBob.setEmail("im_cool_boy@gmail.com");
        coolBob.setPassword("im_the_best");
        Role coolBobsRole = new Role();
        coolBobsRole.setRoleName(ADMIN);
        roleService.add(coolBobsRole);
        coolBob.setRoles(List.of(coolBobsRole));
        userService.add(coolBob);

        User commonAlice = new User();
        commonAlice.setEmail("alice_bobson@gmail.com");
        commonAlice.setPassword("alicok");
        Role commonAlicesRole = new Role();
        commonAlicesRole.setRoleName(USER);
        roleService.add(commonAlicesRole);
        commonAlice.setRoles(List.of(commonAlicesRole));
        userService.add(commonAlice);
    }
}
