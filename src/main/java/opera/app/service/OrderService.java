package opera.app.service;

import opera.app.model.Order;
import opera.app.model.ShoppingCart;
import opera.app.model.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
