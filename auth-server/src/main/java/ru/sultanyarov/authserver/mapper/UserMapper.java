package ru.sultanyarov.authserver.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.io.Resource;
import ru.sultanyarov.authserver.auth.dto.User;
import ru.sultanyarov.authserver.entity.UserEntity;

@Mapper
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "passwordHash", ignore = true)
    UserEntity dtoToEntity(User userDto);

    @Mapping(target = "password", ignore = true)
    User entityToDto(UserEntity entity, Resource photo);
}
