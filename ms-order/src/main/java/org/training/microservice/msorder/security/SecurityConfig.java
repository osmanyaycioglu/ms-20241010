package org.training.microservice.msorder.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder cryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public MyUserDetailService myUserDetailService() {
        return new MyUserDetailService(cryptPasswordEncoder());
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider providerLoc = new DaoAuthenticationProvider();
        providerLoc.setUserDetailsService(myUserDetailService());
        providerLoc.setPasswordEncoder(cryptPasswordEncoder());
        return providerLoc;
    }

    @Bean
    public JWTService jwtService() {
        return new JWTService();
    }

    @Bean
    public JWTFilter jwtFilter() {
        return new JWTFilter(jwtService(),
                             myUserDetailService());
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.cors(CorsConfigurer::disable)
                   .csrf(CsrfConfigurer::disable)
                   .authorizeHttpRequests(a -> a.requestMatchers("/actuator/**",
                                                                 "/security/login")
                                                .anonymous()
                                                .requestMatchers("/order/**")
                                                .hasAnyAuthority("USER",
                                                                 "VIEWER")
                                                .requestMatchers("/api/*/order/**")
                                                .hasAnyAuthority("ADMIN",
                                                                 "SUPER_ADMIN")
                                                .anyRequest()
                                                .authenticated())
                   .addFilterBefore(jwtFilter(),
                                    UsernamePasswordAuthenticationFilter.class)
                   .formLogin(FormLoginConfigurer::disable)
                   .httpBasic(HttpBasicConfigurer::disable)
                   .sessionManagement(SessionManagementConfigurer::disable)
                   .build();
    }

//            http.csrf()
//                    .disable()
//            .cors()
//            .disable()
//            .authorizeRequests()
//            .antMatchers("/actuator/**","/token/**")
//            .anonymous()
//            .antMatchers("/api/**")
//            .hasAnyRole("ADMIN",
//                                "USER")
//            .antMatchers("/greetings/**")
//            .hasAnyRole("ADMIN")
//            .anyRequest()
//            .authenticated()
//            .and()
//            .httpBasic()
//            .and()
//            .sessionManagement()
//            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.addFilterBefore(jwtRequestFilter(),
//    UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//            .antMatchers(HttpMethod.DELETE)
//                .hasRole("ADMIN")
//                .antMatchers("/admin/**")
//                .hasAnyRole("ADMIN")
//                .antMatchers("/user/**")
//                .hasAnyRole("USER",
//                            "ADMIN")
//                .antMatchers("/login/**")
//                .anonymous()


}
