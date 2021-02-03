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
        if (dirty.isPresent() && dirty.get().getPassword()
                .equals(SecurityUtil.hashPassword(password, dirty.get().getSalt()))) {
            return dirty.get();
        }
        throw new AuthenticationException("User doesn't exist");
    }

    @Override
    public User register(String email, String password) {
        User current = new User();
        current.setEmail(email);
        current.setPassword(password);
        return userService.add(current);
    }
}
