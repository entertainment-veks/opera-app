package opera.app.service.mapper.impl;

import opera.app.model.Order;
import opera.app.model.Ticket;
import opera.app.model.dto.OrderResponseDto;
import opera.app.service.mapper.OrderMapper;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class OrderMapperImpl implements OrderMapper {
    @Override
    public OrderResponseDto parseToDto(Order order) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setId(order.getId());
        List<Long> tickets = order.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList());
        dto.setTicketIds(tickets);
        dto.setOrderDate(order.getOrderDate().toString());
        dto.setUserId(order.getUser().getId());
        return dto;
    }
}
