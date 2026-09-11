package hn.alturaforge.mercadox.library.entity.ports.incoming;

import hn.alturaforge.mercadox.library.entity.response.dto.CartDto;

public interface CartUseCase {

    CartDto addToCart(String cartId, String itemId);

    CartDto removeFromCart(String cartId, String itemId);

    CartDto getCartItems(String cartId);

    void clearCart(String cartId);

}
