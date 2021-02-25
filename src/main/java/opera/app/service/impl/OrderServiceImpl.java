package opera.app.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import opera.app.dao.OrderDao;
import opera.app.model.Order;
import opera.app.model.ShoppingCart;
import opera.app.model.User;
import opera.app.service.OrderService;
import opera.app.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;
    private ShoppingCartService shoppingCartService;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao, ShoppingCartService shoppingCartService) {
        this.orderDao = orderDao;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order current = new Order();
        current.setTickets(new ArrayList<>(shoppingCart.getTickets()));
        current.setOrderDate(LocalDateTime.now());
        current.setUser(shoppingCart.getUser());
        shoppingCartService.clear(shoppingCart);
        return orderDao.add(current);
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        return orderDao.getAllOrdersByUser(user);
    }
}
