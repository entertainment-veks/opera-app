package opera.app.service.mapper.impl;

import opera.app.model.Stage;
import opera.app.model.dto.StageRequestDto;
import opera.app.model.dto.StageResponseDto;
import opera.app.service.mapper.StageMapper;
import org.springframework.stereotype.Component;

@Component
public class StageMapperImpl implements StageMapper {
    @Override
    public StageResponseDto parseToDto(Stage stage) {
        StageResponseDto current = new StageResponseDto();
        current.setId(stage.getId());
        current.setCapacity(stage.getCapacity());
        current.setDescription(stage.getDescription());
        return current;
    }

    @Override
    public Stage parseFromDto(StageRequestDto stageRequestDto) {
        Stage current = new Stage();
        current.setCapacity(stageRequestDto.getCapacity());
        current.setDescription(stageRequestDto.getDescription());
        return current;
    }
}
