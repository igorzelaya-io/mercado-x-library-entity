package hn.shadowcore.mercadoxlibrary.entity.response.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@JsonSerialize
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ItemDto {

    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private String categoryId;

    @NotNull
    private BigDecimal unitPrice;

    @NotNull
    private Integer unitQuantity;

    private String branchId;

    private String inventoryId;

    private Boolean inStock;

    private String image;

}
