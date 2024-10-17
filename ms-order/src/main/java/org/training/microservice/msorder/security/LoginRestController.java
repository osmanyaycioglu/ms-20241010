package org.training.microservice.msorder.security;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.microservice.msorder.security.models.Credential;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("security")
@RequiredArgsConstructor
public class LoginRestController {
    private final JWTService             jwtService;
    private final AuthenticationProvider authenticationProvider;

    @PostMapping("/login")
    public String login(@RequestBody @Valid Credential credentialParam) {
        Authentication authenticationLoc = new UsernamePasswordAuthenticationToken(credentialParam.getUsername(),
                                                                                   credentialParam.getPassword());

        Authentication authenticateLoc = authenticationProvider.authenticate(authenticationLoc);
        Object         credentialsLoc  = authenticateLoc.getCredentials();
        Collection<? extends GrantedAuthority> authoritiesLoc = authenticateLoc.getAuthorities();
        System.out.println("Credential : " + credentialsLoc);
        System.out.println("Credential : " + authenticateLoc);
        return jwtService.createToken(credentialParam.getUsername(),
                                      ((UserDetails) authenticateLoc.getPrincipal()).getAuthorities()
                                                                                      .stream()
                                                                                      .map(a -> a.getAuthority())
                                                                                      .collect(Collectors.joining(",")));
    }

}
