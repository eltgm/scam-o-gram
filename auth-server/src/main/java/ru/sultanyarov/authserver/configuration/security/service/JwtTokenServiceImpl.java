package ru.sultanyarov.authserver.configuration.security.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sultanyarov.authserver.configuration.security.model.InternalAuthentication;

import java.security.KeyPair;
import java.security.PublicKey;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class JwtTokenServiceImpl implements JwtTokenService {
    private final KeyPair keyPair;

    @SuppressWarnings("unchecked")
    public InternalAuthentication parseToken(String jwt) {
        try {

            PublicKey publicKey = keyPair.getPublic();
            final Claims claims = Jwts.parserBuilder()
                    .setSigningKey(publicKey)
                    .build()
                    .parseClaimsJws(jwt)
                    .getBody();
            List<String> roles = (List<String>) claims.get("authorities");
            return new InternalAuthentication(claims.getSubject(), true, roles);
        } catch (ExpiredJwtException e) {
            log.info("Token expired");
            return new InternalAuthentication("anonymous", false);
        }
    }
}
