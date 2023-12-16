package ru.sultanyarov.authserver.configuration;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.sultanyarov.common.exception.CommonExceptionHandler;

@RestControllerAdvice(basePackages = "ru.sultanyarov.authserver.controller")
public class AuthServerExceptionHandler extends CommonExceptionHandler {
}
