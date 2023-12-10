package ru.sultanyarov.authserver.converter;

import ru.sultanyarov.authserver.auth.dto.User;
import ru.sultanyarov.authserver.entity.UserEntity;

/**
 * Конвертер для работы с DTO, Entity и Domain
 */
public interface UserConverter {
    /**
     * Конвертирование dto пользователя в entity
     * @param userDto - dto пользователя
     * @return entity пользователя для сохранения в базу
     */
    UserEntity convertToEntity(User userDto);
}
