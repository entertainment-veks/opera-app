package opera.app.service.mapper;

import opera.app.model.Stage;
import opera.app.model.dto.StageRequestDto;
import opera.app.model.dto.StageResponseDto;

public interface StageMapper {
    StageResponseDto parseToDto(Stage stage);

    Stage parseFromDto(StageRequestDto stageRequestDto);
}
