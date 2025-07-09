package hn.shadowcore.mercadoxlibrary.entity.ports.incoming;

import hn.shadowcore.mercadoxlibrary.entity.model.auth.User;

public interface RegistrationUseCase {
    void registerUser(User user);

    void validateUser(String token);

}
