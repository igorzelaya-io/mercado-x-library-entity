package hn.shadowcore.mercadoxlibrary.entity.ports.incoming;

import hn.shadowcore.mercadoxlibrary.entity.model.enums.OrderStatus;
import hn.shadowcore.mercadoxlibrary.entity.response.dto.CartDto;

public interface OrderUseCase {

    OrderStatus place(CartDto cartDto);

    OrderStatus dispatch(String orderId);

    OrderStatus cancel(String orderId);

    OrderStatus close(String orderId);

}
