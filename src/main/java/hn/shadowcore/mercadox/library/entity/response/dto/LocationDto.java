package hn.shadowcore.mercadox.library.entity.response.dto;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonSerialize
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class LocationDto {

    private String id;

    private String address;

    private String locationReference;

}
