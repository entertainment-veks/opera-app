package hibernate.dao;

import hibernate.model.MovieSession;
import java.time.LocalDate;
import java.util.List;

public interface MovieSessionDao {
    List<MovieSession> getAllInTime(Long movieId, LocalDate date);

    MovieSession add(MovieSession movieSession);
}
