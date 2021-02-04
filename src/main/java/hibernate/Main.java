package hibernate;

import hibernate.lib.Injector;
import hibernate.model.CinemaHall;
import hibernate.model.Movie;
import hibernate.model.MovieSession;
import hibernate.model.User;
import hibernate.service.AuthenticationService;
import hibernate.service.CinemaHallService;
import hibernate.service.MovieService;
import hibernate.service.MovieSessionService;
import hibernate.service.ShoppingCartService;
import java.time.LocalDateTime;

public class Main {
    private static Injector injector = Injector.getInstance("hibernate");

    public static void main(String[] args) {
        CinemaHall cinemaHall45 = new CinemaHall();
        cinemaHall45.setCapacity(45);
        cinemaHall45.setDescription("desc1");

        CinemaHall cinemaHall60 = new CinemaHall();
        cinemaHall60.setCapacity(60);
        cinemaHall60.setDescription("desc2");

        CinemaHallService cinemaHallService =
                (CinemaHallService) injector.getInstance(CinemaHallService.class);

        cinemaHallService.add(cinemaHall45);
        cinemaHallService.add(cinemaHall60);

        Movie movie1 = new Movie();
        movie1.setTitle("LoTR");
        movie1.setDescription("Lord of the rings");

        Movie movie2 = new Movie();
        movie2.setTitle("Cars");
        movie2.setDescription("Lightning McQueen is the best");

        MovieService movieService =
                (MovieService) injector.getInstance(MovieService.class);

        final Long id = movieService.add(movie1).getId();
        movieService.add(movie2);

        MovieSession movieSessionLotr = new MovieSession();
        movieSessionLotr.setCinemaHall(cinemaHall45);
        movieSessionLotr.setShowTime(LocalDateTime.now());
        movieSessionLotr.setMovie(movie1);

        MovieSession movieSessionCars = new MovieSession();
        movieSessionCars.setCinemaHall(cinemaHall60);
        movieSessionCars.setShowTime(LocalDateTime.now());
        movieSessionCars.setMovie(movie2);

        MovieSessionService movieSessionService =
                (MovieSessionService) injector.getInstance(MovieSessionService.class);

        movieSessionService.add(movieSessionLotr);
        movieSessionService.add(movieSessionCars);

        AuthenticationService authenticationService =
                (AuthenticationService) injector.getInstance(AuthenticationService.class);

        User bob = authenticationService.register("bob", "pass");
        System.out.println(bob);

        ShoppingCartService shoppingCartService =
                (ShoppingCartService) injector.getInstance(ShoppingCartService.class);

        shoppingCartService.addSession(movieSessionLotr, bob);

        System.out.println(shoppingCartService.getByUser(bob));

        shoppingCartService.clear(shoppingCartService.getByUser(bob));

        System.out.println(shoppingCartService.getByUser(bob));
    }
}
