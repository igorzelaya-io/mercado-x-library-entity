package hn.shadowcore.mercadoxlibrary.entity.ports.incoming;

import hn.shadowcore.mercadoxlibrary.entity.model.enums.OrderStatus;
import hn.shadowcore.mercadoxlibrary.entity.request.PlaceOrderRequest;

public interface OrderUseCase {

    OrderStatus place(PlaceOrderRequest orderRequest);

    OrderStatus dispatch(String orderId);

    OrderStatus cancel(String orderId);

    OrderStatus close(String orderId);

}
