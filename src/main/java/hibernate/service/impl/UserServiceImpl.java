package hibernate.service.impl;

import hibernate.dao.UserDao;
import hibernate.lib.Inject;
import hibernate.lib.Service;
import hibernate.model.User;
import hibernate.service.UserService;
import hibernate.util.SecurityUtil;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private UserDao userDao;

    @Override
    public User add(User user) {
        user.setSalt(SecurityUtil.getSalt());
        String hashedPassword = SecurityUtil.hashPassword(user.getPassword(), user.getSalt());
        user.setPassword(hashedPassword);
        return userDao.add(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
