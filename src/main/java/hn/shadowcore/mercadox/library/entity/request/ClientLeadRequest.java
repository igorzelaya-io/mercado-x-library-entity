package hn.shadowcore.mercadox.library.entity.request;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    @Size(max = 100)
    private String userName;

    @JsonSerialize
    @NotBlank
    @Size(max = 100)
    private String orgName;

    @JsonSerialize
    @NotBlank
    @Email
    @Size(max = 254)
    private String email;

    @JsonSerialize
    @NotBlank
    @Pattern(regexp = "^[0-9+()\\-\\s]{7,20}$")
    private String phoneNumber;

    @JsonSerialize
    @Size(max = 2000)
    private String message;

    // Honeypot: legitimate callers must leave this blank. Bots that
    // auto-fill every form field populate it, letting the caller drop the
    // submission silently without revealing that it was detected.
    @JsonSerialize
    private String website;
}
