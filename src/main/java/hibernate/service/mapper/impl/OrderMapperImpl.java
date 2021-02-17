package hibernate.service.mapper.impl;

import hibernate.model.Order;
import hibernate.model.Ticket;
import hibernate.model.dto.OrderResponseDto;
import hibernate.service.mapper.OrderMapper;
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
