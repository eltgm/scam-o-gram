package ru.sultanyarov.authserver.facade.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.sultanyarov.authserver.auth.dto.User;
import ru.sultanyarov.authserver.auth.dto.UserInfo;
import ru.sultanyarov.authserver.converter.UserConverter;
import ru.sultanyarov.authserver.facade.UserFacade;
import ru.sultanyarov.authserver.mapper.UserMapper;
import ru.sultanyarov.authserver.service.OidcUserInfoService;
import ru.sultanyarov.authserver.service.UserService;
import ru.sultanyarov.authserver.validator.UserValidator;

import java.time.LocalDate;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserFacadeImpl implements UserFacade {
    private final UserConverter userConverter;
    private final UserService userService;
    private final UserMapper userMapper;
    private final UserValidator userValidator;
    private final OidcUserInfoService oidcUserInfoService;

    @Override
    public User registerUser(String username, String password, String name, String surname, LocalDate birthDate, String sex, String middleName, MultipartFile photo) {
        userValidator.validateUser(username);

        var userDto = new User(username, password, name, surname, birthDate, User.SexEnum.fromValue(sex));
        userDto.setMiddleName(middleName);
        Resource profilePhoto = photo == null ? null : photo.getResource();
        userDto.setPhoto(profilePhoto);

        return userMapper.entityToDto(
                userService.registerUser(
                        userConverter.convertToEntity(userDto)
                ), profilePhoto
        );
    }

    @Override
    public UserInfo getUserInfo(String username) {
        return userMapper.oidcDomainToDto(oidcUserInfoService.loadUser(username));
    }
}
