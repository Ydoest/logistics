package com.logistics.kindstar.common.filter;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * jwt身份验证过滤器
 * 自定义过滤器
 * token验证
 *
 * @author KG06884
 * @date 2022-01-17
 */
public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public JwtAuthenticationFilter() {
        super(new AntPathRequestMatcher("/login", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        String userLoginName = request.getParameter("userLoginName");
        String userLoginPassword = request.getParameter("userLoginPassword");
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(userLoginName, userLoginPassword);
        return getAuthenticationManager().authenticate(authRequest);
    }
}
