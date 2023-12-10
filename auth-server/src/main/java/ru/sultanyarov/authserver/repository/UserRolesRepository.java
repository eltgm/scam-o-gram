package ru.sultanyarov.authserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sultanyarov.authserver.entity.RoleEntity;

import java.util.Optional;

public interface UserRolesRepository extends JpaRepository<RoleEntity, Integer> {
    Optional<RoleEntity> findByRole(String role);
}
