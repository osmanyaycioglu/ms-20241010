package org.training.microservice.msorder.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class JWTFilter extends OncePerRequestFilter {
    private final JWTService         jwtService;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(final HttpServletRequest request,
                                    final HttpServletResponse response,
                                    final FilterChain filterChain) throws ServletException, IOException {
        String authorizationLoc = request.getHeader("Authorization");
        if (authorizationLoc == null || authorizationLoc.isEmpty() || !authorizationLoc.startsWith("Bearer")) {
            filterChain.doFilter(request,
                                 response);
            return;
        }
        String      tokenLoc    = authorizationLoc.substring(7);
        Jws<Claims> validateLoc = jwtService.validate(tokenLoc);
        if (validateLoc == null) {
            response.setStatus(401);
            response.addHeader("Content-Type",
                               "text/plain;charset=UTF-8");
            response.getWriter()
                    .println("Token is not valid");
            return;
        }
        Claims      payloadLoc     = validateLoc.getPayload();
        String      usernameLoc    = payloadLoc.getSubject();
        UserDetails userDetailsLoc = null;
        try {
            userDetailsLoc = userDetailsService.loadUserByUsername(usernameLoc);
        } catch (UsernameNotFoundException eParam) {
            response.setStatus(401);
            response.addHeader("Content-Type",
                               "text/plain;charset=UTF-8");
            response.getWriter()
                    .println("Not valid user");
            return;
        }

        Authentication authenticationLoc = new UsernamePasswordAuthenticationToken(usernameLoc,
                                                                                   userDetailsLoc.getPassword(),
                                                                                   userDetailsLoc.getAuthorities());
        SecurityContextHolder.getContext()
                             .setAuthentication(authenticationLoc);
        filterChain.doFilter(request,
                             response);
    }

}
