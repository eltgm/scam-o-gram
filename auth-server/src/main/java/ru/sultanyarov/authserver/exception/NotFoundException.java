package ru.sultanyarov.authserver.exception;

import org.springframework.http.HttpStatus;
import ru.sultanyarov.common.errorhandler.BusinessError;
import ru.sultanyarov.common.exception.BusinessException;

@BusinessError(
        status = HttpStatus.NOT_FOUND,
        errorCode = "notFound",
        message = "User not found"
)
public class NotFoundException extends BusinessException {
}
