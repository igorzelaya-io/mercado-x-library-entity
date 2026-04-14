package hn.shadowcore.mercadox.library.entity.ports.incoming;

import hn.shadowcore.mercadox.library.entity.model.auth.User;

public interface RegistrationUseCase {
    void registerUser(User user);

    void validateUser(String token);

}
