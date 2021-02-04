package hibernate.dao;

import hibernate.model.Order;
import hibernate.model.User;
import java.util.List;

public interface OrderDao {
    Order add(Order order);

    List<Order> getAllOrdersByUser(User user);
}
