package opera.app.service.mapper;

import opera.app.model.Order;
import opera.app.model.dto.OrderResponseDto;

public interface OrderMapper {
    OrderResponseDto parseToDto(Order order);
}
