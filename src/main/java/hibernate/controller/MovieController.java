package hibernate.controller;

import hibernate.model.Movie;
import hibernate.model.dto.MovieRequestDto;
import hibernate.model.dto.MovieResponseDto;
import hibernate.service.MovieService;
import hibernate.service.mapper.MovieMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private MovieService movieService;
    private MovieMapper movieMapper;

    @Autowired
    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @PostMapping
    public void saveMovie(@RequestBody MovieRequestDto movieRequestDto) {
        Movie current = movieMapper.parseFromDto(movieRequestDto);
        movieService.add(current);
    }

    @GetMapping
    public List<MovieResponseDto> getAllMovies() {
        return movieService.getAll().stream()
                .map(movieMapper::parseToDto)
                .collect(Collectors.toList());
    }
}
