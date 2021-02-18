package hibernate.service.mapper;

import hibernate.model.User;
import hibernate.model.dto.UserResponseDto;

public interface UserMapper {
    UserResponseDto parseToDto(User user);
}
