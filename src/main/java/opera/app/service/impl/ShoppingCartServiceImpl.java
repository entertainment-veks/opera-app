package opera.app.service.impl;

import opera.app.dao.ShoppingCartDao;
import opera.app.dao.TicketDao;
import opera.app.model.PerformanceSession;
import opera.app.model.ShoppingCart;
import opera.app.model.Ticket;
import opera.app.model.User;
import opera.app.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private ShoppingCartDao shoppingCartDao;
    private TicketDao ticketDao;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartDao shoppingCartDao, TicketDao ticketDao) {
        this.shoppingCartDao = shoppingCartDao;
        this.ticketDao = ticketDao;
    }

    @Override
    public void addSession(PerformanceSession performanceSession, User user) {
        Ticket currentTicket = new Ticket();
        currentTicket.setMovieSession(performanceSession);
        currentTicket.setUser(user);

        ShoppingCart currentCart = shoppingCartDao.getByUser(user);
        ticketDao.add(currentTicket);
        currentCart.getTickets().add(currentTicket);
        shoppingCartDao.update(currentCart);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        return shoppingCartDao.getByUser(user);
    }

    @Override
    public void registerNewShoppingCart(User user) {
        ShoppingCart currentCart = new ShoppingCart();
        currentCart.setUser(user);
        shoppingCartDao.add(currentCart);
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.getTickets().clear();
        shoppingCartDao.update(shoppingCart);
    }
}
