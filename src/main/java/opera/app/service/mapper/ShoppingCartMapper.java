package opera.app.service.mapper;

import opera.app.model.ShoppingCart;
import opera.app.model.dto.ShoppingCartResponseDto;

public interface ShoppingCartMapper {
    ShoppingCartResponseDto parseToDto(ShoppingCart shoppingCart);
}
