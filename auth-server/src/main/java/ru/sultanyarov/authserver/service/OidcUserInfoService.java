package ru.sultanyarov.authserver.service;

import org.springframework.security.oauth2.core.oidc.OidcUserInfo;

/**
 * Сервис, загружающий информацию о пользователе для использования с OpenID Connect 1.0
 */
public interface OidcUserInfoService {
    /**
     * Получение хранилища пользовательской информации для передачи с помощью oidc
     * @param username - логин пользователя
     * @return представление информации о пользователе
     */
    OidcUserInfo loadUser(String username);
}
