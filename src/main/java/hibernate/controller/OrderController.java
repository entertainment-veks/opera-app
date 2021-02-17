package hibernate.controller;

import hibernate.model.dto.OrderResponseDto;
import hibernate.service.OrderService;
import hibernate.service.ShoppingCartService;
import hibernate.service.UserService;
import hibernate.service.mapper.OrderMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;
    private ShoppingCartService shoppingCartService;
    private UserService userService;
    private OrderMapper orderMapper;

    public OrderController(OrderService orderService, ShoppingCartService shoppingCartService,
                           UserService userService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.orderMapper = orderMapper;
    }

    @PostMapping("/complete")
    public void completeOrder(@RequestBody Long userId) {
        orderService.completeOrder(shoppingCartService.getByUser(userService.get(userId)));
    }

    @GetMapping
    public List<OrderResponseDto> getOrdersHistory(@RequestBody Long userId) {
        return orderService.getOrdersHistory(userService.get(userId)).stream()
                .map(orderMapper::parseToDto)
                .collect(Collectors.toList());
    }
}
