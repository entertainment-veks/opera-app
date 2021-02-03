package hibernate.service;

import hibernate.exception.AuthenticationException;
import hibernate.model.User;

public interface AuthenticationService {
    User login(String email, String password) throws AuthenticationException;

    User register(String email, String password);
}
