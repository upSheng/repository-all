package com.web.config;

import com.alibaba.fastjson.JSON;
import com.web.modal.Response;
import com.web.modal.ResponseCodeEnum;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Administrator
 */
@Component
public class AjaxAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {


        Response<String> response = new Response<>(ResponseCodeEnum.FAIL);

        httpServletResponse.getWriter().write(JSON.toJSONString(response));
    }
}
