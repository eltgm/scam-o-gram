package ru.sultanyarov.authserver.converter.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.sultanyarov.authserver.auth.dto.User;
import ru.sultanyarov.authserver.converter.UserConverter;
import ru.sultanyarov.authserver.entity.RoleEntity;
import ru.sultanyarov.authserver.entity.UserEntity;
import ru.sultanyarov.authserver.mapper.UserMapper;
import ru.sultanyarov.authserver.repository.UserRolesRepository;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserConverterImpl implements UserConverter {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRolesRepository userRolesRepository;

    public UserEntity convertToEntity(User userDto) {
        UserEntity userEntity = userMapper.dtoToEntity(userDto);
        userEntity.setPasswordHash(passwordEncoder.encode(userDto.getPassword()));
        userEntity.setIsEnabled(true);
        Optional<RoleEntity> optionalRole = userRolesRepository.findByRole("CLIENT");
        optionalRole.ifPresent(roleEntity -> userEntity.setRoles(List.of(roleEntity)));

        return userEntity;
    }
}
