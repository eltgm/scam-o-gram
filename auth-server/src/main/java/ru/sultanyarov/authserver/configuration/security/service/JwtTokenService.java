package ru.sultanyarov.authserver.configuration.security.service;


import ru.sultanyarov.authserver.configuration.security.model.InternalAuthentication;

public interface JwtTokenService {

    /**
     * Retrieves user information from the token(jwt).
     *
     * @param jwt token from "Authorization" header.
     * @return user authentication info.
     */
    InternalAuthentication parseToken(String jwt);
}
