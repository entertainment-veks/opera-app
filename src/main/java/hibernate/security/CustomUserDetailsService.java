package hibernate.security;

import static org.springframework.security.core.userdetails.User.withUsername;

import hibernate.model.User;
import hibernate.service.UserService;
import java.util.stream.Collectors;
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
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User current = userService.findByEmail(s).orElseThrow(() ->
                new UsernameNotFoundException("Can't find user with email " + s));
        UserBuilder userBuilder = withUsername(current.getEmail())
                .password(current.getPassword())
                .roles(current.getRoles().stream()
                .map(r -> r.getRoleName().toString())
                .collect(Collectors.joining(", ")));
        return userBuilder.build();
    }
}
