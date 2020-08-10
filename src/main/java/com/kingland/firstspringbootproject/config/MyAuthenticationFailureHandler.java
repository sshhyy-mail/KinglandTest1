/**

 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.

 */
package com.kingland.firstspringbootproject.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Failed login processors
 */
@Component
public class MyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    /**
     *
     * @throws AuthenticationException:Exceptions during authentication
     */

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {



        response.setContentType("application/json;charset=UTF-8");
        ObjectMapper objectMapper = new ObjectMapper();

        //Convert authentication object to JSON format
        response.getWriter().append(objectMapper.writeValueAsString("login failture, please check your username/password and try again."));

    }
}
