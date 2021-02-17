package hibernate.service.mapper;

import hibernate.model.ShoppingCart;
import hibernate.model.dto.ShoppingCartResponseDto;

public interface ShoppingCartMapper {
    ShoppingCartResponseDto parseToDto(ShoppingCart shoppingCart);
}
