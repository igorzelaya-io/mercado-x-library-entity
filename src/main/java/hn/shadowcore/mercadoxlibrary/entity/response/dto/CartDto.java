package hn.shadowcore.mercadoxlibrary.entity.response.dto;

import java.util.List;

public record CartDto(
        String userId,
        List<ItemDto> cartItems
) {}
