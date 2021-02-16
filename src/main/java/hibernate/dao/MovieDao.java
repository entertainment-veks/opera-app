package hibernate.dao;

import hibernate.model.Movie;
import java.util.List;

public interface MovieDao {
    Movie add(Movie movie);

    List<Movie> getAll();

    Movie get(Long id);
}
