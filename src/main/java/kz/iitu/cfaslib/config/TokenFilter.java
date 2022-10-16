package kz.iitu.cfaslib.config;

import kz.iitu.cfaslib.dto.TokenDto;
import kz.iitu.cfaslib.util.CurrentUserHolder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

// TODO Придумать другой способ, этот мне не нравится
@Component
@RequiredArgsConstructor
@Slf4j
public class TokenFilter extends OncePerRequestFilter {

    private final JdbcTemplate jdbcTemplate;

    private static final String AUTHORIZATION_HEADER = "Authorization";

    private static final String BEARER_PREFIX = "Bearer";

    private static final List<String> allowed = List.of("/login", "/register");

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(AUTHORIZATION_HEADER);
        token = (!Objects.isNull(token) && token.startsWith(BEARER_PREFIX)) ?
                token.substring(7) : null;

        if (!allowed.contains(request.getRequestURI().substring(request.getContextPath().length()))) {
            String username = "";
            try {
                TokenDto tokenDto = jdbcTemplate.queryForObject("SELECT * FROM token WHERE id=?",
                        new BeanPropertyRowMapper<>(TokenDto.class),
                        token);
                username = Optional.ofNullable(tokenDto).map(TokenDto::getUserId).orElse("");

            } catch (EmptyResultDataAccessException exception) {
                log.error("Could not find user by token {} ", token);
            }
            CurrentUserHolder.currentUser.set(username);
        }
        filterChain.doFilter(request, response);
    }
}
