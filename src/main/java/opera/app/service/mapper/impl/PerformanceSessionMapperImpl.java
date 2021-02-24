package opera.app.service.mapper.impl;

import opera.app.model.PerformanceSession;
import opera.app.model.dto.PerformanceSessionRequestDto;
import opera.app.model.dto.PerformanceSessionResponseDto;
import opera.app.service.StageService;
import opera.app.service.PerformanceService;
import opera.app.service.mapper.PerformanceSessionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PerformanceSessionMapperImpl implements PerformanceSessionMapper {
    private PerformanceService performanceService;
    private StageService stageService;

    @Autowired
    public PerformanceSessionMapperImpl(PerformanceService performanceService, StageService stageService) {
        this.performanceService = performanceService;
        this.stageService = stageService;
    }

    @Override
    public PerformanceSessionResponseDto parseToDto(PerformanceSession performanceSession) {
        PerformanceSessionResponseDto current = new PerformanceSessionResponseDto();
        current.setPerformanceSessionId(performanceSession.getId());
        current.setPerformanceTitle(performanceSession.getPerformance().getTitle());
        current.setCinemaHallId(performanceSession.getCinemaHall().getId());
        current.setShowTime(performanceSession.getShowTime());
        return current;
    }

    @Override
    public PerformanceSession parseFromDto(PerformanceSessionRequestDto performanceSessionRequestDto) {
        PerformanceSession current = new PerformanceSession();
        current.setPerformance(performanceService.get(performanceSessionRequestDto.getPerformanceId()));
        current.setCinemaHall(stageService.get(performanceSessionRequestDto.getCinemaHallId()));
        current.setShowTime(performanceSessionRequestDto.getShowTime());
        return current;
    }
}
