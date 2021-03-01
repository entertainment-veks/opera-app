package opera.app.controller;

import opera.app.model.dto.ShoppingCartResponseDto;
import opera.app.service.PerformanceSessionService;
import opera.app.service.ShoppingCartService;
import opera.app.service.UserService;
import opera.app.service.mapper.ShoppingCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartMapper shoppingCartMapper;
    private final PerformanceSessionService performanceSessionService;
    private final UserService userService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  ShoppingCartMapper shoppingCartMapper,
                                  PerformanceSessionService performanceSessionService,
                                  UserService userService) {
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartMapper = shoppingCartMapper;
        this.performanceSessionService = performanceSessionService;
        this.userService = userService;
    }

    @PostMapping("/movie-sessions")
    public void addMovieSession(Authentication authentication, @RequestParam Long movieSessionId) {
        UserDetails details = (UserDetails) authentication.getPrincipal();
        String email = details.getUsername();
        shoppingCartService
                .addSession(performanceSessionService.get(movieSessionId),
                        userService.findByEmail(email).get());
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getShoppingCartByUser(Authentication authentication) {
        UserDetails details = (UserDetails) authentication.getPrincipal();
        String email = details.getUsername();
        return shoppingCartMapper
                .parseToDto(shoppingCartService.getByUser(userService.findByEmail(email).get()));
    }
}
