package hibernate.service.mapper;

import hibernate.model.CinemaHall;
import hibernate.model.dto.CinemaHallRequestDto;
import hibernate.model.dto.CinemaHallResponseDto;

public interface CinemaHallMapper {
    CinemaHallResponseDto parseToDto(CinemaHall cinemaHall);

    CinemaHall parseFromDto(CinemaHallRequestDto cinemaHallRequestDto);
}
