package hn.shadowcore.mercadoxlibrary.entity.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public final class AuthRequestDto {

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;

}
