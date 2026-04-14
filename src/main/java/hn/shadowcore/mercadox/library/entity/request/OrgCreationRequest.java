package hn.shadowcore.mercadox.library.entity.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@JsonSerialize
@NoArgsConstructor
@AllArgsConstructor
public final class OrgCreationRequest {

    @NotBlank
    @JsonProperty
    private String name;

    @Email
    @NotBlank
    @JsonProperty
    private String orgEmail;

    @NotBlank
    @JsonProperty
    private String orgPhone;

}
