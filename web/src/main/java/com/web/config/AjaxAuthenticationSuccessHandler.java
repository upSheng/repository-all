package com.web.config;

import com.alibaba.fastjson.JSON;
import com.web.modal.Response;
import com.web.modal.ResponseCodeEnum;
import com.web.util.JwtTokenUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {


        SelfUserDetails userDetails = (SelfUserDetails) authentication.getPrincipal();

        String jwtToken = JwtTokenUtil.generateToken(userDetails.getUsername(), 300, "_secret");
        Response<String> response = new Response<>(ResponseCodeEnum.OK, jwtToken);


        httpServletResponse.getWriter().write(JSON.toJSONString(response));
    }
}

