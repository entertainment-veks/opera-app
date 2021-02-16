package hibernate.service.mapper;

import hibernate.model.Movie;
import hibernate.model.dto.MovieRequestDto;
import hibernate.model.dto.MovieResponseDto;

public interface MovieMapper {
    MovieResponseDto parseToDto(Movie movie);

    Movie parseFromDto(MovieRequestDto movieRequestDto);
}
