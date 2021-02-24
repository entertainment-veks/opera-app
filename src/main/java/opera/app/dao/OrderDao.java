package opera.app.dao;

import opera.app.model.Order;
import opera.app.model.User;
import java.util.List;

public interface OrderDao {
    Order add(Order order);

    List<Order> getAllOrdersByUser(User user);
}
