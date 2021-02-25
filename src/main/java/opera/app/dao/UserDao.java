package opera.app.dao;

import java.util.Optional;
import opera.app.model.User;

public interface UserDao {
    User add(User user);

    Optional<User> findByEmail(String email);

    Optional<User> get(Long id);
}
