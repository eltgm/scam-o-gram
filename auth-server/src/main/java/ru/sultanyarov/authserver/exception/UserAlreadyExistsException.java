package ru.sultanyarov.authserver.exception;

import org.springframework.http.HttpStatus;
import ru.sultanyarov.common.errorhandler.BusinessError;
import ru.sultanyarov.common.exception.BusinessException;

@BusinessError(
        status = HttpStatus.CONFLICT,
        message = "User already exists",
        errorCode = "userAlreadyExists"
)
public class UserAlreadyExistsException extends BusinessException {
    public UserAlreadyExistsException(String username) {
    }
}
