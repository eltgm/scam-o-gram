package ru.sultanyarov.common.errorhandler;

import org.springframework.http.HttpStatus;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для бизнес ошибок. Вешается на классы-наследники от BusinessErrorException.
 * Транслируется в хэндлере CommonExceptionHandler в json вида
 * {
 * "applicationErrorCode": "code",
 * "message": "",
 * "debug": "",
 * }
 * <p>
 * По умолчанию Поля applicationErrorCode, message, debug берутся из соответствующих атрибутов этой аннотации.
 * <p>
 * Поля message и debug могут быть переопределены, задав значения полей responseMessage и responseDebug
 * класса BusinessErrorException, если требутеся передать динамические данные.*
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface BusinessError {
    HttpStatus status() default HttpStatus.BAD_REQUEST;

    /**
     * Business error's code
     */
    String errorCode() default "";

    /**
     * Business error's message
     */
    String message() default "";

    /**
     * Debug information
     */
    String debug() default "";
}
