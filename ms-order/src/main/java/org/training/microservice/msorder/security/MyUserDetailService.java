package org.training.microservice.msorder.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class MyUserDetailService implements UserDetailsService {
    private final BCryptPasswordEncoder passwordEncoder;

    private Map<String, User> userMap = new ConcurrentHashMap<>();


    public MyUserDetailService(BCryptPasswordEncoder passwordEncoderParam) {
        passwordEncoder = passwordEncoderParam;
        userMap.put("osman",
                    (User) User.builder()
                               .username("osman")
                               .password(passwordEncoder.encode("123456"))
                               .authorities("SUPER_ADMIN")
                               .build());
        userMap.put("mehmet",
                    (User) User.builder()
                               .username("mehmet")
                               .password(passwordEncoder.encode("123456"))
                               .authorities("ADMIN")
                               .build());
        userMap.put("ali",
                    (User) User.builder()
                               .username("ali")
                               .password(passwordEncoder.encode("123456"))
                               .authorities("USER")
                               .build());
        userMap.put("nil",
                    (User) User.builder()
                               .username("nil")
                               .password(passwordEncoder.encode("123456"))
                               .authorities("VIEWER")
                               .build());
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        User userLoc = userMap.get(username);
        if (userLoc == null) {
            throw new UsernameNotFoundException("Yok");
        }
        return new User(userLoc.getUsername(),
                        userLoc.getPassword(),
                        userLoc.getAuthorities());
    }
}
