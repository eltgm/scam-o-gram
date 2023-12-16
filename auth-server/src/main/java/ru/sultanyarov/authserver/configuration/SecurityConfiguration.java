package ru.sultanyarov.authserver.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.sultanyarov.authserver.configuration.security.filter.JwtAuthFilter;
import ru.sultanyarov.authserver.service.impl.CustomUserDetailsService;

/**
 * Внутренняя конфигурация авторизация для сервера авторизации
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final CustomUserDetailsService customUserDetailsService;
    private final JwtAuthFilter filter;

    @Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().requestMatchers("/favicon.ico", "/resources/**", "/error", "/api/v1/user_info");
    }

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
                .userDetailsService(customUserDetailsService)
                .csrf(AbstractHttpConfigurer::disable) //TODO разобраться, с ним не работает кастомная страница авторизации - вечный редирект
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .dispatcherTypeMatchers().permitAll()
                                .requestMatchers("/registration.html", "/api/v1/user/register").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(httpSecurityFormLoginConfigurer ->
                        httpSecurityFormLoginConfigurer
                                .loginProcessingUrl("/login")
                                .loginPage("/authorization.html")
                                .permitAll());
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
