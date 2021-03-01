package opera.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(getEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/register").permitAll()
                .antMatchers(HttpMethod.GET,"/cinema-halls").permitAll()
                .antMatchers(HttpMethod.POST,"/cinema-halls").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/movies").permitAll()
                .antMatchers(HttpMethod.POST,"/movies").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/movie-sessions/available").permitAll()
                .antMatchers(HttpMethod.GET,"/movie-sessions/{id}").permitAll()
                .antMatchers(HttpMethod.POST,"/movie-sessions").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/movie-sessions/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/movie-sessions/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/orders").hasRole("USER")
                .antMatchers(HttpMethod.POST,"/orders/complete").hasRole("USER")
                .antMatchers(HttpMethod.POST,"/shopping-carts/movie-sessions").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/shopping-carts/by-user").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/users/by-email").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }

    @Bean
    public PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }
}
