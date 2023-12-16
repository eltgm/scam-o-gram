package ru.sultanyarov.authserver.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.io.Resource;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import ru.sultanyarov.authserver.auth.dto.User;
import ru.sultanyarov.authserver.auth.dto.UserInfo;
import ru.sultanyarov.authserver.entity.UserEntity;

import java.time.LocalDate;
import java.util.Map;

@Mapper
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "passwordHash", ignore = true)
    UserEntity dtoToEntity(User userDto);

    @Mapping(target = "password", ignore = true)
    User entityToDto(UserEntity entity, Resource photo);

    @Mapping(target = "nickname", source = "username")
    @Mapping(target = "familyName", source = "surname")
    @Mapping(target = "picture", ignore = true) //TODO EPIC TRE-91
    @Mapping(target = "birthdate", source = "birthDate")
    @Mapping(target = "gender", source = "sex")
    @Mapping(target = "subject", source = "username")
    OidcUserInfo entityToOidc(UserEntity userEntity);

    @Mapping(target = "sub", expression = "java(getInfoFromClaims(oidcUserInfo.getClaims(), \"sub\"))")
    @Mapping(target = "nickname", expression = "java(getInfoFromClaims(oidcUserInfo.getClaims(), \"nickname\"))")
    @Mapping(target = "name", expression = "java(getInfoFromClaims(oidcUserInfo.getClaims(), \"name\"))")
    @Mapping(target = "birthDate", expression = "java(getBirthdateFromClaims(oidcUserInfo.getClaims()))")
    UserInfo oidcDomainToDto(OidcUserInfo oidcUserInfo);

    default String getInfoFromClaims(Map<String, Object> claims, String sub) {
        return (String) claims.get(sub);
    }

    default LocalDate getBirthdateFromClaims(Map<String, Object> claims) {
        return LocalDate.parse((String) claims.get("birthdate"));
    }
}
