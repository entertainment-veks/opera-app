package hibernate.service.impl;

import hibernate.dao.OrderDao;
import hibernate.lib.Inject;
import hibernate.lib.Service;
import hibernate.model.Order;
import hibernate.model.ShoppingCart;
import hibernate.model.User;
import hibernate.service.OrderService;
import hibernate.service.ShoppingCartService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Inject
    private OrderDao orderDao;
    @Inject
    private ShoppingCartService shoppingCartService;

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
