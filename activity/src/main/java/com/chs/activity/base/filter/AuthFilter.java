package com.chs.activity.base.filter;

import com.alibaba.fastjson.JSON;
import com.chs.activity.base.response.ResponseEntity;
import com.chs.activity.dao.UserMapper;
import com.chs.activity.modal.entity.UserEntity;
import com.chs.activity.utils.JwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @author : HongSheng.Chen
 * @date : 2020/12/24 9:39
 */

@Component
@WebFilter(urlPatterns = {"/*"})
public class AuthFilter implements Filter {


    @Resource
    private UserMapper userMapper;

    private static HashMap<String, Integer> authURLMap = new HashMap<>();
    private final static String TOKEN = "token";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String uri = httpRequest.getRequestURI();

        //url 是否能匹配
        boolean flag = false;
        for (Map.Entry<String, Integer> entry : authURLMap.entrySet()) {
            if (uri.startsWith(entry.getKey())) {
                flag = true;
                String token = httpRequest.getHeader(TOKEN);
                if (!StringUtils.isEmpty(token)) {
                    String userId = JwtUtils.verifierToken(token);
                    if (!StringUtils.isEmpty(userId)) {
                        UserEntity user = userMapper.findById(Integer.valueOf(userId));
                        if (entry.getValue().equals(0) || 1 == user.getAdmin()) {
                            chain.doFilter(request, response);
                            return;
                        }
                    }
                }
            }
        }

        if (flag) {
            httpResponse.setHeader("Access-Control-Allow-Origin", "*");
            httpResponse.setHeader("Content-Type", "application/json;charset=UTF-8");
            httpResponse.setHeader("Access-Control-Allow-Headers", "*");
            String res = JSON.toJSONString(ResponseEntity.fail(401, "no login"));
            httpResponse.getWriter().append(res);
        } else {
            chain.doFilter(request, response);
            return;
        }
    }


    static {
//        authURLMap.put("/wheel", 0);
//        authURLMap.put("/list", 1);
//        authURLMap.put("/save", 1);
    }
}
