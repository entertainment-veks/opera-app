package opera.app.service.mapper;

import opera.app.model.Performance;
import opera.app.model.dto.PerformanceRequestDto;
import opera.app.model.dto.PerformanceResponseDto;

public interface PerformanceMapper {
    PerformanceResponseDto parseToDto(Performance performance);

    Performance parseFromDto(PerformanceRequestDto performanceRequestDto);
}
