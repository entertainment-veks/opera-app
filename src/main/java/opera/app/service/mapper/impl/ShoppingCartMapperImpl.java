package opera.app.service.mapper.impl;

import java.util.List;
import java.util.stream.Collectors;
import opera.app.model.ShoppingCart;
import opera.app.model.Ticket;
import opera.app.model.dto.ShoppingCartResponseDto;
import opera.app.service.mapper.ShoppingCartMapper;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapperImpl implements ShoppingCartMapper {
    @Override
    public ShoppingCartResponseDto parseToDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto dto = new ShoppingCartResponseDto();
        dto.setId(shoppingCart.getId());
        List<Long> tickets = shoppingCart.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList());
        dto.setTicketIds(tickets);
        return dto;
    }
}
