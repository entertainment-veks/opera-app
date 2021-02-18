package hibernate.service.impl;

import hibernate.config.SecurityConfig;
import hibernate.dao.UserDao;
import hibernate.model.User;
import hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private SecurityConfig securityConfig;

    @Autowired
    public UserServiceImpl(UserDao userDao, SecurityConfig securityConfig) {
        this.userDao = userDao;
        this.securityConfig = securityConfig;
    }

    @Override
    public User add(User user) {
        String hashedPassword = securityConfig.getEncoder().encode(user.getPassword());
        user.setPassword(hashedPassword);
        return userDao.add(user);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email).get();
    }

    @Override
    public User get(Long id) {
        return userDao.get(id).get();
    }
}
