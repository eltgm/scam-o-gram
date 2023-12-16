package ru.sultanyarov.authserver.validator;

/**
 * Сервис для валидирования пользователя
 */
public interface UserValidator {

    /**
     * Проверка существования пользователя
     * @param username - логин нового пользователя
     */
    void validateUser(String username);
}
