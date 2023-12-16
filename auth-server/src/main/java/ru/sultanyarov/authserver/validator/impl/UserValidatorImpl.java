package ru.sultanyarov.authserver.validator.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sultanyarov.authserver.exception.UserAlreadyExistsException;
import ru.sultanyarov.authserver.repository.UserRepository;
import ru.sultanyarov.authserver.validator.UserValidator;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserValidatorImpl implements UserValidator {
    private final UserRepository userRepository;

    @Override
    public void validateUser(String username) {
        log.info("Check user {} existence", username);
        userRepository.findByUsername(username).ifPresent(userEntity -> {
            log.error("User with username {} already exists", username);
            throw new UserAlreadyExistsException(username);
        });
    }
}
