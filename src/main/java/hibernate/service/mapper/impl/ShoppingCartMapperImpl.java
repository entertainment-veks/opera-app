package hibernate.service.mapper.impl;

import hibernate.model.ShoppingCart;
import hibernate.model.Ticket;
import hibernate.model.dto.ShoppingCartResponseDto;
import hibernate.service.mapper.ShoppingCartMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapperImpl implements ShoppingCartMapper {
    @Override
    public ShoppingCartResponseDto parseToDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto current = new ShoppingCartResponseDto();
        current.setId(shoppingCart.getId());
        List<Long> tickets = shoppingCart.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList());
        current.setTickets(tickets);
        return current;
    }
}
