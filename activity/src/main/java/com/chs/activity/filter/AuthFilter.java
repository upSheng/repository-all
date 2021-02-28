package com.chs.activity.filter;

import com.chs.activity.utils.JwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : HongSheng.Chen
 * @date : 2020/12/24 9:39
 */

@Component
@WebFilter(urlPatterns = {"/*"})
public class AuthFilter implements Filter {

    private static HashMap<String, Boolean> notAuthURLMap = new HashMap<>();
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
        if (!isAuthRequest(httpRequest)) {
            chain.doFilter(request, response);
            return;
        }

        String token = httpRequest.getHeader(TOKEN);
        if (!StringUtils.isEmpty(token)) {
            String userId = JwtUtils.verifierToken(token);
            if (!StringUtils.isEmpty(userId)) {
                chain.doFilter(request, response);
                return;
            }
        }

        httpResponse.setHeader("Content-Type", "application/json;charset=UTF-8");
        httpResponse.getWriter().append("no login");


    }


    private boolean isAuthRequest(HttpServletRequest request) {
        String uri = request.getRequestURI();
        for (Map.Entry<String, Boolean> entry : notAuthURLMap.entrySet()) {
            if (uri.startsWith(entry.getKey())) {
                return false;
            }
        }
        return true;
    }

    static {
        notAuthURLMap.put("/wheel", true);
        notAuthURLMap.put("/user", true);
        notAuthURLMap.put("/fund", true);
    }
}
