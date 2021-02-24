package opera.app.controller;

import opera.app.model.PerformanceSession;
import opera.app.model.dto.PerformanceSessionRequestDto;
import opera.app.model.dto.PerformanceSessionResponseDto;
import opera.app.service.PerformanceSessionService;
import opera.app.service.mapper.PerformanceSessionMapper;
import jakarta.validation.Valid;
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
@RequestMapping("/performance-sessions")
public class PerformanceSessionController {
    private final PerformanceSessionService performanceSessionService;
    private final PerformanceSessionMapper performanceSessionMapper;

    @Autowired
    public PerformanceSessionController(PerformanceSessionService performanceSessionService,
                                        PerformanceSessionMapper performanceSessionMapper) {
        this.performanceSessionService = performanceSessionService;
        this.performanceSessionMapper = performanceSessionMapper;
    }

    @PostMapping
    public void savePerformanceSession(@RequestBody @Valid
                                         PerformanceSessionRequestDto performanceSessionRequestDto) {
        PerformanceSession current = performanceSessionMapper.parseFromDto(performanceSessionRequestDto);
        performanceSessionService.add(current);
    }

    @GetMapping("/available")
    public List<PerformanceSessionResponseDto> getAllPerformanceSessions(@RequestParam Long performanceId,
             @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return performanceSessionService.findAvailableSessions(performanceId, date).stream()
                .map(performanceSessionMapper::parseToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public void updatePerformanceSession(@PathVariable Long id,
                                   @RequestBody @Valid
                                           PerformanceSessionRequestDto performanceSessionRequestDto) {
        PerformanceSession performanceSession = performanceSessionMapper.parseFromDto(performanceSessionRequestDto);
        performanceSession.setId(id);
        performanceSessionService.update(performanceSession);
    }

    @DeleteMapping("/{id}")
    public void deletePerformanceSession(@PathVariable Long id) {
        performanceSessionService.delete(id);
    }
}
