package hibernate.service.mapper;

import hibernate.model.Order;
import hibernate.model.dto.OrderResponseDto;

public interface OrderMapper {
    OrderResponseDto parseToDto(Order order);
}
