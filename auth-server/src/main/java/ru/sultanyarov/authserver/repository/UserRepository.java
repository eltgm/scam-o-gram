package ru.sultanyarov.authserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sultanyarov.authserver.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}
