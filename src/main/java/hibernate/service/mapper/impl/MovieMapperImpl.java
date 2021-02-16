package hibernate.service.mapper.impl;

import hibernate.model.Movie;
import hibernate.model.dto.MovieRequestDto;
import hibernate.model.dto.MovieResponseDto;
import hibernate.service.mapper.MovieMapper;
import org.springframework.stereotype.Component;

@Component
public class MovieMapperImpl implements MovieMapper {
    @Override
    public MovieResponseDto parseToDto(Movie movie) {
        MovieResponseDto current = new MovieResponseDto();
        current.setId(movie.getId());
        current.setTitle(movie.getTitle());
        current.setDescription(movie.getDescription());
        return current;
    }

    @Override
    public Movie parseFromDto(MovieRequestDto movieRequestDto) {
        Movie current = new Movie();
        current.setTitle(movieRequestDto.getTitle());
        current.setDescription(movieRequestDto.getDescription());
        return current;
    }
}
