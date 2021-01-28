package hibernate.service;

import hibernate.model.Movie;
import java.util.List;

public interface MovieService {
    Movie add(Movie movie);

    List<Movie> getAll();
}
