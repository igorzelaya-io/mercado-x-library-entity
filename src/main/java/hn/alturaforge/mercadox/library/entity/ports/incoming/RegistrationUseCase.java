package hn.alturaforge.mercadox.library.entity.ports.incoming;

import hn.alturaforge.mercadox.library.entity.model.auth.User;

public interface RegistrationUseCase {
    void registerUser(User user);

    void validateUser(String token);

}
