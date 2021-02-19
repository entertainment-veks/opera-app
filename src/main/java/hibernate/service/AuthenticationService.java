package hibernate.service;

import hibernate.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
