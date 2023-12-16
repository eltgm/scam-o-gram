package ru.sultanyarov.authserver.configuration.security.model;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.Transient;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.security.Principal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Transient
public class InternalAuthentication implements Authentication {

    private final String name;
    private boolean isAuthenticated;
    private final List<String> authorities;

    public InternalAuthentication(String name, boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
        this.authorities = Collections.emptyList();
        this.name = name;
    }

    public InternalAuthentication(String name, boolean isAuthenticated, List<String> authorities) {
        this.isAuthenticated = isAuthenticated;
        this.authorities = authorities == null ? Collections.emptyList() : authorities;
        this.name = name;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return (Principal) () -> name;
    }

    @Override
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.isAuthenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return this.name;
    }

}
