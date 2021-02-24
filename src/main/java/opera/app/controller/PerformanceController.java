package opera.app.controller;

import opera.app.model.Performance;
import opera.app.model.dto.PerformanceRequestDto;
import opera.app.model.dto.PerformanceResponseDto;
import opera.app.service.PerformanceService;
import opera.app.service.mapper.PerformanceMapper;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/performances")
public class PerformanceController {
    private PerformanceService performanceService;
    private PerformanceMapper performanceMapper;

    @Autowired
    public PerformanceController(PerformanceService performanceService, PerformanceMapper performanceMapper) {
        this.performanceService = performanceService;
        this.performanceMapper = performanceMapper;
    }

    @PostMapping
    public void savePerformance(@RequestBody @Valid PerformanceRequestDto performanceRequestDto) {
        Performance current = performanceMapper.parseFromDto(performanceRequestDto);
        performanceService.add(current);
    }

    @GetMapping
    public List<PerformanceResponseDto> getAllPerformances() {
        return performanceService.getAll().stream()
                .map(performanceMapper::parseToDto)
                .collect(Collectors.toList());
    }
}
