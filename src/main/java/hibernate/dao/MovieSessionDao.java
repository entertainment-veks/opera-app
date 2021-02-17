package hibernate.dao;

import hibernate.model.MovieSession;
import java.time.LocalDate;
import java.util.List;

public interface MovieSessionDao {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    MovieSession add(MovieSession movieSession);

    MovieSession get(Long id);

    MovieSession update(MovieSession movieSession);

    boolean delete(Long id);
}
