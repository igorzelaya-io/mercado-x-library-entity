package hn.shadowcore.mercadoxlibrary.entity.request;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
@JsonSerialize
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
