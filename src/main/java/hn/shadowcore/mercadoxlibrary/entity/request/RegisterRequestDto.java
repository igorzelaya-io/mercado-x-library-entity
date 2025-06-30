package hn.shadowcore.mercadoxlibrary.entity.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import hn.shadowcore.mercadoxlibrary.entity.model.auth.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterRequestDto(
    @JsonProperty @NotBlank @Size(max = 64)
    String username,
    @JsonProperty @NotBlank @Size(min = 8)
    String password,
    @JsonProperty @NotBlank @Size(max = 64)
    String firstName,
    @JsonProperty @NotBlank @Size(max = 64)
    String lastName,
    @JsonProperty @Email @NotBlank
    String email,
    @NotNull
    UserType userType,
    @NotBlank
    String orgId

){ }
