package hn.shadowcore.mercadox.library.entity.request;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@JsonSerialize
@NoArgsConstructor
@AllArgsConstructor
public final class ClientLeadRequest {

    @JsonSerialize
    @NotBlank
    private String userName;

    @JsonSerialize
    @NotBlank
    private String orgName;

    @JsonSerialize
    @NotBlank
    private String email;

    @JsonSerialize
    @NotBlank
    private String phoneNumber;

    @JsonSerialize
    private String message;
}
