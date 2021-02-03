package hibernate.service.impl;

import hibernate.exception.AuthenticationException;
import hibernate.lib.Inject;
import hibernate.lib.Service;
import hibernate.model.User;
import hibernate.service.AuthenticationService;
import hibernate.service.UserService;
import hibernate.util.SecurityUtil;
import java.util.Optional;

@Service
public class AuthentificationServiceImpl implements AuthenticationService {
    @Inject
    private UserService userService;

    @Override
    public User login(String email, String password) throws AuthenticationException {
        Optional<User> dirty = userService.findByEmail(email);
        if (dirty.isEmpty()) {
            throw new AuthenticationException("User doesn't exist");
        }
        User current = dirty.get();
        String hashedInput = SecurityUtil.hashPassword(password, current.getSalt());
        if (!current.getPassword().equals(hashedInput)) {
            throw new AuthenticationException("passwords don't match");
        }
        return current;
    }

    @Override
    public User register(String email, String password) {
        User current = new User();
        current.setEmail(email);
        current.setPassword(password);
        return userService.add(current);
    }
}
