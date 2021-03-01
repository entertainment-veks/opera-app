package opera.app.service;

import opera.app.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
