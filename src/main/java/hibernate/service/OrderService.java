package hibernate.service;

import hibernate.model.Order;
import hibernate.model.ShoppingCart;
import hibernate.model.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
