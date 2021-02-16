package hibernate.controller;

import hibernate.model.CinemaHall;
import hibernate.model.dto.CinemaHallRequestDto;
import hibernate.model.dto.CinemaHallResponseDto;
import hibernate.service.CinemaHallService;
import hibernate.service.mapper.CinemaHallMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private CinemaHallService cinemaHallService;
    private CinemaHallMapper cinemaHallMapper;

    @Autowired
    public CinemaHallController(CinemaHallService cinemaHallService,
                                CinemaHallMapper cinemaHallMapper) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallMapper = cinemaHallMapper;
    }

    @PostMapping
    public void saveCinemaHall(@RequestBody CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall current = cinemaHallMapper.parseFromDto(cinemaHallRequestDto);
        cinemaHallService.add(current);
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAllCinemaHalls() {
        return cinemaHallService.getAll().stream()
                .map(cinemaHallMapper::parseToDto)
                .collect(Collectors.toList());
    }
}
