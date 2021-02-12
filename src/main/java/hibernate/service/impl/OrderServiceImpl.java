package hibernate.service.impl;

import hibernate.dao.OrderDao;
import hibernate.model.Order;
import hibernate.model.ShoppingCart;
import hibernate.model.User;
import hibernate.service.OrderService;
import hibernate.service.ShoppingCartService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
