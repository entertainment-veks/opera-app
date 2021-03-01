package opera.app.service;

import java.util.List;
import opera.app.model.Order;
import opera.app.model.ShoppingCart;
import opera.app.model.User;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
