package hibernate.service.mapper.impl;

import hibernate.model.MovieSession;
import hibernate.model.dto.MovieSessionRequestDto;
import hibernate.model.dto.MovieSessionResponseDto;
import hibernate.service.CinemaHallService;
import hibernate.service.MovieService;
import hibernate.service.mapper.MovieSessionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapperImpl implements MovieSessionMapper {
    private MovieService movieService;
    private CinemaHallService cinemaHallService;

    @Autowired
    public MovieSessionMapperImpl(MovieService movieService, CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    @Override
    public MovieSessionResponseDto parseToDto(MovieSession movieSession) {
        MovieSessionResponseDto current = new MovieSessionResponseDto();
        current.setMovieSessionId(movieSession.getId());
        current.setMovieTitle(movieSession.getMovie().getTitle());
        current.setCinemaHallId(movieSession.getCinemaHall().getId());
        current.setShowTime(movieSession.getShowTime());
        return current;
    }

    @Override
    public MovieSession parseFromDto(MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession current = new MovieSession();
        current.setMovie(movieService.get(movieSessionRequestDto.getMovieId()));
        current.setCinemaHall(cinemaHallService.get(movieSessionRequestDto.getCinemaHallId()));
        current.setShowTime(movieSessionRequestDto.getShowTime());
        return current;
    }
}
