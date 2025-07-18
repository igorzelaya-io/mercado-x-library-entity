package hn.shadowcore.mercadoxlibrary.entity.ports.incoming;

import hn.shadowcore.mercadoxlibrary.entity.model.core.Order;
import hn.shadowcore.mercadoxlibrary.entity.model.enums.OrderStatus;

import java.util.List;

public interface OrderQueryUseCase {

    List<Order> findAllUnderReview();

    List<Order> findAllForUserAndStatus(String userId, OrderStatus orderStatus);

}
