package ru.sultanyarov.authserver.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.sultanyarov.authserver.auth.UserApi;
import ru.sultanyarov.authserver.auth.dto.User;
import ru.sultanyarov.authserver.auth.dto.UserInfo;
import ru.sultanyarov.authserver.facade.UserFacade;

import java.time.LocalDate;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1")
public class UserController implements UserApi {
    private final UserFacade userFacade;

    @Override
    public ResponseEntity<User> registerUser(String username, String password, String name, String surname, LocalDate birthDate, String sex, String middleName, MultipartFile photo) {
        return ResponseEntity.ok(
                userFacade.registerUser(username, password, name, surname, birthDate, sex, middleName, photo)
        );
    }

    @Override
    public ResponseEntity<UserInfo> userInfo() {
        return ResponseEntity.ok(
                userFacade.getUserInfo(SecurityContextHolder.getContext().getAuthentication().getName())
        );
    }
}
