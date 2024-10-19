package org.training.microservice.apitestcaller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/caller")
public class TestCallerRestController {

    private WebClient webClient;

    public TestCallerRestController(WebClient webClient) {
        this.webClient = webClient;
    }

    @PreAuthorize("hasAuthority('SCOPE_TEST')")
    @GetMapping("/doit")
    public String doit() {
        SecurityContext context        = SecurityContextHolder.getContext();
        Authentication  authentication = context.getAuthentication();

        String scopes = webClient
                .get()
                .uri("http://localhost:8040/test/callme")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return "Test call me response : " + scopes;
    }

}
