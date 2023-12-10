package ru.sultanyarov.authserver.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sultanyarov.authserver.entity.UserEntity;
import ru.sultanyarov.authserver.repository.UserRepository;
import ru.sultanyarov.authserver.service.UserService;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserEntity registerUser(UserEntity userEntity) {
        log.info("Start registration user");
        return userRepository.save(userEntity);
    }
}
