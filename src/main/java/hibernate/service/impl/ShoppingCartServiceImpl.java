package hibernate.service.impl;

import hibernate.dao.ShoppingCartDao;
import hibernate.dao.TicketDao;
import hibernate.lib.Inject;
import hibernate.lib.Service;
import hibernate.model.MovieSession;
import hibernate.model.ShoppingCart;
import hibernate.model.Ticket;
import hibernate.model.User;
import hibernate.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Inject
    private ShoppingCartDao shoppingCartDao;

    @Inject
    private TicketDao ticketDao;

    @Override
    public void addSession(MovieSession movieSession, User user) {
        Ticket currentTicket = new Ticket();
        currentTicket.setMovieSession(movieSession);
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
