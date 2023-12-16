package ru.sultanyarov.authserver.configuration.security.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.sultanyarov.authserver.configuration.security.service.JwtTokenServiceImpl;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private static final String AUTHORIZATION_HEADER = "Authorization";

    private static final String TOKEN_BEARER_PREFIX = "Bearer ";

    private final JwtTokenServiceImpl jwtTokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws jakarta.servlet.ServletException, IOException {
        final String authHeader = request.getHeader(AUTHORIZATION_HEADER);
        if (authHeader != null && authHeader.startsWith(TOKEN_BEARER_PREFIX)) {
            log.debug("Setting jwt authentication. URI: {}", request.getRequestURI());
            SecurityContextHolder.getContext().setAuthentication(jwtTokenService.parseToken(authHeader.replace(TOKEN_BEARER_PREFIX, "")));
        }
        filterChain.doFilter(request, response);
    }
}
