package ru.sultanyarov.authserver.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.stereotype.Service;
import ru.sultanyarov.authserver.entity.UserEntity;
import ru.sultanyarov.authserver.mapper.UserMapper;
import ru.sultanyarov.authserver.service.OidcUserInfoService;
import ru.sultanyarov.authserver.service.UserService;

@Slf4j
@Service
@RequiredArgsConstructor
public class OidcUserInfoServiceImpl implements OidcUserInfoService {
    private final UserService userService;
    private final UserMapper userMapper;

    @Override
    public OidcUserInfo loadUser(String username) {
        UserEntity userEntity = userService.findByUsername(username);

        return userMapper.entityToOidc(userEntity);
    }
}
