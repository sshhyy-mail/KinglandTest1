/**

 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.

 */
package com.kingland.firstspringbootproject.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Successfully logged in processors
 */
@Component
public class MyAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    /**
     *Authentication encapsulates authentication information
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().append(objectMapper.writeValueAsString("User: " + authentication.getName() + ", login successful. Roles: " + authentication.getAuthorities().toString()));
    }

}