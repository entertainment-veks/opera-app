package opera.app.security;

import static org.springframework.security.core.userdetails.User.withUsername;

import java.util.stream.Collectors;
import opera.app.model.User;
import opera.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserService userService;

    @Autowired
    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User current = userService.findByEmail(username).orElseThrow(() ->
                new UsernameNotFoundException("Can't find user with email " + username));
        UserBuilder userBuilder = withUsername(current.getEmail())
                .password(current.getPassword())
                .roles(current.getRoles().stream()
                .map(r -> r.getRoleName().toString())
                .collect(Collectors.joining(", ")));
        return userBuilder.build();
    }
}
