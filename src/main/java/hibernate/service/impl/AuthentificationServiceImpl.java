package hibernate.service.impl;

import hibernate.model.User;
import hibernate.service.AuthenticationService;
import hibernate.service.RoleService;
import hibernate.service.ShoppingCartService;
import hibernate.service.UserService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationServiceImpl implements AuthenticationService {
    private UserService userService;
    private ShoppingCartService shoppingCartService;
    private RoleService roleService;

    @Autowired
    public AuthentificationServiceImpl(UserService userService,
                                       ShoppingCartService shoppingCartService,
                                       RoleService roleService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.roleService = roleService;
    }

    @Override
    public User register(String email, String password) {
        User current = new User();
        current.setEmail(email);
        current.setPassword(password);
        current.setRoles(Set.of(roleService.getRoleByName("USER")));
        current = userService.add(current);
        shoppingCartService.registerNewShoppingCart(current);
        return current;
    }
}
