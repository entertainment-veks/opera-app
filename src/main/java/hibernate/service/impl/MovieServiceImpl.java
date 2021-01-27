package hibernate.service.impl;

import hibernate.dao.MovieDao;
import hibernate.lib.Inject;
import hibernate.lib.Service;
import hibernate.model.Movie;
import hibernate.service.MovieService;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Inject
    MovieDao movieDao;

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }
}
