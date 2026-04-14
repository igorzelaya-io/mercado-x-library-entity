package hn.shadowcore.mercadox.library.entity.ports.incoming;

import hn.shadowcore.mercadox.library.entity.request.DispatchOrderRequest;
import hn.shadowcore.mercadox.library.entity.request.PlaceOrderRequest;
import hn.shadowcore.mercadox.library.entity.model.enums.OrderStatus;

public interface OrderUseCase {

    OrderStatus place(PlaceOrderRequest orderRequest);

    OrderStatus dispatch(DispatchOrderRequest request);

    OrderStatus cancel(String orderId);

    OrderStatus close(String orderId);

}
