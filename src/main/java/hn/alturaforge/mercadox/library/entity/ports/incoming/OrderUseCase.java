package hn.alturaforge.mercadox.library.entity.ports.incoming;

import hn.alturaforge.mercadox.library.entity.request.DispatchOrderRequest;
import hn.alturaforge.mercadox.library.entity.request.PlaceOrderRequest;
import hn.alturaforge.mercadox.library.entity.model.enums.OrderStatus;

public interface OrderUseCase {

    OrderStatus place(PlaceOrderRequest orderRequest);

    OrderStatus dispatch(DispatchOrderRequest request);

    OrderStatus cancel(String orderId);

    OrderStatus close(String orderId);

}
