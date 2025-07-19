package hn.shadowcore.mercadoxlibrary.entity.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import hn.shadowcore.mercadoxlibrary.entity.response.dto.CartDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@JsonSerialize
@Data
public class PlaceOrderRequest {

    @JsonProperty
    @NotNull
    private CartDto cartDto;

    @JsonProperty
    @NotBlank
    private String locationId;

}
