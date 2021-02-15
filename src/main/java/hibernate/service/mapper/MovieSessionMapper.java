package hibernate.service.mapper;

import hibernate.model.MovieSession;
import hibernate.model.dto.MovieSessionRequestDto;
import hibernate.model.dto.MovieSessionResponseDto;

public interface MovieSessionMapper {
    MovieSessionResponseDto parseToDto(MovieSession movieSession);

    MovieSession parseFromDto(MovieSessionRequestDto movieSessionRequestDto);
}
