package hibernate;

import hibernate.lib.Injector;
import hibernate.model.Movie;
import hibernate.service.MovieService;

public class Main {
    private static Injector injector = Injector.getInstance("hibernate");

    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setTitle("Fast and Furious");
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);
        movieService.add(movie);

        movieService.getAll().forEach(System.out::println);
    }
}
