package com.lpp.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ImageCodeAuthenticationFilter extends OncePerRequestFilter {
    private AuthenticationFailureHandler authenticationFailureHandler;

    public void setAuthenticationFailureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
        this.authenticationFailureHandler = authenticationFailureHandler;
    }

    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        //        判断是否为登录请求
        if(httpServletRequest.getRequestURI().contains("/login")){
            try {
                //            用户输入的验证码
                String input = httpServletRequest.getParameter("imageCode");
//            系统生成的
                String key = (String)httpServletRequest.getSession().getAttribute("key");
                if(StringUtils.isEmpty(input)){
                    throw new ImageCodeException("验证码不能为空");
                }
                if(!input.trim().equals(key)){
                    throw new ImageCodeException("验证码错误");
                }

            }catch (AuthenticationException e){
                authenticationFailureHandler.onAuthenticationFailure(httpServletRequest,httpServletResponse,e);
                return;
            }
        }
        doFilter(httpServletRequest,httpServletResponse,filterChain);
    }
}
