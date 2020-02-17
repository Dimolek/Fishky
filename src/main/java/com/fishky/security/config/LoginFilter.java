package com.fishky.security.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fishky.dto.user.UserLoginDto;
import com.fishky.security.service.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class LoginFilter extends AbstractAuthenticationProcessingFilter {

    public LoginFilter(String url, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
    }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        UserLoginDto userLoginDto = new ObjectMapper()
                .readValue(httpServletRequest.getInputStream(), UserLoginDto.class);
        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                        userLoginDto.getUsername(),
                        userLoginDto.getPassword(),
                        Collections.emptyList()
                )
        );
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        AuthenticationService.addToken(response, authResult.getName());

    }
}