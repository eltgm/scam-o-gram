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

    /**
     * Получение пользователя по логину
     * @param username - логин пользователя
     * @return информация о пользователе
     */
    UserEntity findByUsername(String username);
}
