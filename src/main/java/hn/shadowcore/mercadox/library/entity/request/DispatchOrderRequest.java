package hn.shadowcore.mercadox.library.entity.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
@JsonSerialize
public class DispatchOrderRequest {

    @JsonProperty
    private String deliveryEmployee;

    @JsonProperty
    private String customer;

    @JsonProperty
    private String locationId;

    @JsonProperty
    private String orderId;

}
