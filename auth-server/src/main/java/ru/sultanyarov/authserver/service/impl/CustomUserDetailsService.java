package ru.sultanyarov.authserver.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sultanyarov.authserver.entity.RoleEntity;
import ru.sultanyarov.authserver.entity.UserEntity;
import ru.sultanyarov.authserver.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> byUsername = userRepository.findByUsername(username);
        UserEntity userEntity = byUsername.orElseThrow(() -> new UsernameNotFoundException(String.format("User with username %s not found", username)));

        return new User(
                userEntity.getUsername(),
                userEntity.getPasswordHash(),
                userEntity.getIsEnabled(),
                true,
                true,
                true,
                getAuthorities(userEntity.getRoles())
        );
    }

    private List<? extends GrantedAuthority> getAuthorities(List<RoleEntity> roles) {
        return roles.stream()
                .map((Function<RoleEntity, GrantedAuthority>) roleEntity
                        -> new SimpleGrantedAuthority(roleEntity.getRole()))
                .collect(Collectors.toList());
    }
}
