package opera.app.dao;

import java.util.List;
import opera.app.model.Order;
import opera.app.model.User;

public interface OrderDao {
    Order add(Order order);

    List<Order> getAllOrdersByUser(User user);
}
