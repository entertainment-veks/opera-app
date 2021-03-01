package opera.app.service.mapper.impl;

import opera.app.model.Performance;
import opera.app.model.dto.PerformanceRequestDto;
import opera.app.model.dto.PerformanceResponseDto;
import opera.app.service.mapper.PerformanceMapper;
import org.springframework.stereotype.Component;

@Component
public class PerformanceMapperImpl implements PerformanceMapper {
    @Override
    public PerformanceResponseDto parseToDto(Performance performance) {
        PerformanceResponseDto current = new PerformanceResponseDto();
        current.setId(performance.getId());
        current.setTitle(performance.getTitle());
        current.setDescription(performance.getDescription());
        return current;
    }

    @Override
    public Performance parseFromDto(PerformanceRequestDto performanceRequestDto) {
        Performance current = new Performance();
        current.setTitle(performanceRequestDto.getTitle());
        current.setDescription(performanceRequestDto.getDescription());
        return current;
    }
}
