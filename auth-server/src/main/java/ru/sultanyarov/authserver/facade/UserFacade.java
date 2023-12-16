package ru.sultanyarov.authserver.facade;

import org.springframework.web.multipart.MultipartFile;
import ru.sultanyarov.authserver.auth.dto.User;
import ru.sultanyarov.authserver.auth.dto.UserInfo;

import java.time.LocalDate;

/**
 * Фасад для доступа к сервису с пользователями
 */
public interface UserFacade {

    /**
     * Зарегистрировать пользователя
     *
     * @param username   - логин
     * @param password   - пароль
     * @param name       - имя
     * @param surname    - фамилия
     * @param birthDate  - дата рождения
     * @param sex        - пол
     * @param middleName - отчество
     * @param photo      - фото профиля
     * @return зарегестрированный пользователь
     */
    User registerUser(String username, String password, String name, String surname, LocalDate birthDate, String sex, String middleName, MultipartFile photo);

    /**
     * Получение информации о пользователе
     *
     * @param username - логин пользователя
     * @return Информацию о пользователе для OIDC
     */
    UserInfo getUserInfo(String username);
}
