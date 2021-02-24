package opera.app.service.mapper;

import opera.app.model.User;
import opera.app.model.dto.UserResponseDto;

public interface UserMapper {
    UserResponseDto parseToDto(User user);
}
