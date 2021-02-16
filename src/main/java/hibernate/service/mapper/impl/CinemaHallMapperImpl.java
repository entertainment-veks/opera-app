package hibernate.service.mapper.impl;

import hibernate.model.CinemaHall;
import hibernate.model.dto.CinemaHallRequestDto;
import hibernate.model.dto.CinemaHallResponseDto;
import hibernate.service.mapper.CinemaHallMapper;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapperImpl implements CinemaHallMapper {
    @Override
    public CinemaHallResponseDto parseToDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto current = new CinemaHallResponseDto();
        current.setId(cinemaHall.getId());
        current.setCapacity(cinemaHall.getCapacity());
        current.setDescription(cinemaHall.getDescription());
        return current;
    }

    @Override
    public CinemaHall parseFromDto(CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall current = new CinemaHall();
        current.setCapacity(cinemaHallRequestDto.getCapacity());
        current.setDescription(cinemaHallRequestDto.getDescription());
        return current;
    }
}
