package hibernate.service.impl;

import hibernate.model.User;
import hibernate.service.AuthenticationService;
import hibernate.service.ShoppingCartService;
import hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationServiceImpl implements AuthenticationService {
    private UserService userService;
    private ShoppingCartService shoppingCartService;

    @Autowired
    public AuthentificationServiceImpl(UserService userService,
                                       ShoppingCartService shoppingCartService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public User register(String email, String password) {
        User current = new User();
        current.setEmail(email);
        current.setPassword(password);
        current = userService.add(current);
        shoppingCartService.registerNewShoppingCart(current);
        return current;
    }
}
