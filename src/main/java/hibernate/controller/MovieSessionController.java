package hibernate.controller;

import hibernate.model.MovieSession;
import hibernate.model.dto.MovieSessionRequestDto;
import hibernate.model.dto.MovieSessionResponseDto;
import hibernate.service.MovieSessionService;
import hibernate.service.mapper.MovieSessionMapper;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final MovieSessionMapper movieSessionMapper;

    @Autowired
    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionMapper movieSessionMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionMapper = movieSessionMapper;
    }

    @PostMapping
    public void saveMovieSession(@RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession current = movieSessionMapper.parseFromDto(movieSessionRequestDto);
        movieSessionService.add(current);
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAllMovieSessions(@RequestParam Long movieId,
             @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date).stream()
                .map(movieSessionMapper::parseToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public void updateMovieSession(@PathVariable Long id,
                                   @RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = movieSessionMapper.parseFromDto(movieSessionRequestDto);
        movieSession.setId(id);
        movieSessionService.update(movieSession);
    }

    @DeleteMapping("/{id}")
    public void deleteMovieSession(@PathVariable Long id) {
        movieSessionService.delete(id);
    }
}
