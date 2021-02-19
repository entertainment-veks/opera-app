package hibernate.service;

import hibernate.model.User;

public interface UserService {
    User add(User user);

    User findByEmail(String email);

    User get(Long id);
}
