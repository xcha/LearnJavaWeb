package com.lianci;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class JwtTest {
    @Test
    public void testGenerateJwt() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("id", 1);
        dataMap.put("username", "admin");
        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256,"c2LlkajmmI7lopg=")
                .addClaims(dataMap)
                .setExpiration(new Date(System.currentTimeMillis()+3600*1000))
                .compact();
        System.out.println(jwt);
    }

    @Test
    public void testParseJwt(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJhZG1pbiIsImV4cCI6MTc0ODk0MjIyNH0.5LYtopv8qq83ptF-dDZq_rDpM6YTu1qj0xowS9Mdjx4";
        Claims claims = Jwts.parser().setSigningKey("c2LlkajmmI7lopg=")
                .parseClaimsJws(token)
                .getBody();
        System.out.println(claims);
    }
}
