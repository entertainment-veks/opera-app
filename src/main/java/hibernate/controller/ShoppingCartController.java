package hibernate.controller;

import hibernate.model.dto.ShoppingCartResponseDto;
import hibernate.service.MovieSessionService;
import hibernate.service.ShoppingCartService;
import hibernate.service.UserService;
import hibernate.service.mapper.ShoppingCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private ShoppingCartService shoppingCartService;
    private ShoppingCartMapper shoppingCartMapper;
    private MovieSessionService movieSessionService;
    private UserService userService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  ShoppingCartMapper shoppingCartMapper,
                                  MovieSessionService movieSessionService,
                                  UserService userService) {
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartMapper = shoppingCartMapper;
        this.movieSessionService = movieSessionService;
        this.userService = userService;
    }

    @PostMapping("/movie-sessions")
    public void addMovieSession(@RequestBody Long userId, @RequestBody Long movieSessionId) {
        shoppingCartService
                .addSession(movieSessionService.get(movieSessionId), userService.get(userId));
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getShoppingCartByUser(@RequestBody Long userId) {
        return shoppingCartMapper
                .parseToDto(shoppingCartService.getByUser(userService.get(userId)));
    }
}
