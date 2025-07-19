package hn.shadowcore.mercadoxlibrary.entity.response.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class OrderDto {

    private String id;

    private String createdAt;

    private String customerName;

    private String shippingAddress;

    private String locationReference;

    private String organization;

    private List<String> itemNames;

    private int quantity;

}
