package ru.sultanyarov.authserver.service;

import ru.sultanyarov.authserver.entity.UserEntity;

/**
 * Сервис для работы с пользователями
 */
public interface UserService {

    /**
     * Регистрация пользователя
     * @param userEntity подготовленная сущность пользователя
     */
    UserEntity registerUser(UserEntity userEntity);
}
