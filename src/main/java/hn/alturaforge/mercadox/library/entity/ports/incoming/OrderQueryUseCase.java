package hn.alturaforge.mercadox.library.entity.ports.incoming;

import hn.alturaforge.mercadox.library.entity.model.core.Order;
import hn.alturaforge.mercadox.library.entity.model.enums.OrderStatus;

import java.util.List;

public interface OrderQueryUseCase {

    List<Order> findAllUnderReview();

    Order findOrderById(String orderId);

    List<Order> findAllForUserAndStatus(String userId, OrderStatus orderStatus);

}
