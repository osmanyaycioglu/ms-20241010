package org.training.microservice.msorder.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

public class JWTService {

    private SecretKey key;

    public JWTService() {
        key = Keys.hmacShaKeyFor("sdkjfghdsjhfgdsfghjdsjfbdhcjhdbcdjschbdsjcbhdsjhcbdscds34234".getBytes());
    }

    public String createToken(String username,
                              String scope) {
        return Jwts.builder()
                   .subject(username)
                   .expiration(Date.from(ZonedDateTime.now()
                                                      .plusHours(1)
                                                      .toInstant()))
                   .issuedAt(new Date())
                   .claim("test",
                          UUID.randomUUID()
                              .toString())
                   .claim("scope",
                          scope)
                   .signWith(key)
                   .compact();
    }

    public Jws<Claims> validate(String sParam) {
        try {
            return Jwts.parser()
                       .verifyWith(key)
                       .build()
                       .parseSignedClaims(sParam);
        } catch (Exception eParam) {
            eParam.printStackTrace();
        }
        return null;
    }

}
