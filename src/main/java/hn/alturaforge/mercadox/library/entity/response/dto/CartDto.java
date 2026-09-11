package hn.alturaforge.mercadox.library.entity.response.dto;

import java.util.List;

public record CartDto(
        String userId,
        List<ItemDto> cartItems
) {}
