package hn.shadowcore.mercadox.library.entity.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class AuthRequestDto {

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;

}
