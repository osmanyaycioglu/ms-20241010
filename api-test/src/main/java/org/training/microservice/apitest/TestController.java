package org.training.microservice.apitest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @PreAuthorize("hasAuthority('SCOPE_TEST')")
    @GetMapping("/callme")
    public String callme() {
        SecurityContext context        = SecurityContextHolder.getContext();
        Authentication  authentication = context.getAuthentication();
        System.out.println("************* Scopes : " + authentication.getAuthorities());
        return "Scopes: " + authentication.getAuthorities();
    }

}
