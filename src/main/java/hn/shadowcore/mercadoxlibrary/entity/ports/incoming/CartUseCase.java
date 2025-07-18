package hn.shadowcore.mercadoxlibrary.entity.ports.incoming;

import hn.shadowcore.mercadoxlibrary.entity.response.dto.CartDto;

public interface CartUseCase {

    CartDto addToCart(String cartId, String itemId);

    CartDto removeFromCart(String cartId, String itemId);

    CartDto getCartItems(String cartId);

    void clearCart(String cartId);

}
