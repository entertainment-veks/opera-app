package opera.app.service;

import opera.app.model.PerformanceSession;
import opera.app.model.ShoppingCart;
import opera.app.model.User;

public interface ShoppingCartService {
    void addSession(PerformanceSession performanceSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
