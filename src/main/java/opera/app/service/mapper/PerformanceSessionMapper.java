package opera.app.service.mapper;

import opera.app.model.PerformanceSession;
import opera.app.model.dto.PerformanceSessionRequestDto;
import opera.app.model.dto.PerformanceSessionResponseDto;

public interface PerformanceSessionMapper {
    PerformanceSessionResponseDto parseToDto(PerformanceSession performanceSession);

    PerformanceSession parseFromDto(PerformanceSessionRequestDto performanceSessionRequestDto);
}
