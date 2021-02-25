package opera.app.service;

import java.util.Optional;
import opera.app.model.User;

public interface UserService {
    User add(User user);

    Optional<User> findByEmail(String email);

    User get(Long id);
}
