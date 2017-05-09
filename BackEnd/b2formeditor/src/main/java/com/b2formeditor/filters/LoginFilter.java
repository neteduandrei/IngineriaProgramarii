package com.b2formeditor.filters;

import com.b2formeditor.models.authenticationmodels.LoginCredentials;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by jolde on 02.05.2017.
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        String httpMethod = httpRequest.getMethod();
        HttpSession session = httpRequest.getSession(true);
        LoginCredentials credentials = (LoginCredentials) session.getAttribute("credentials");

        if (httpMethod.equalsIgnoreCase("OPTIONS") || credentials != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            httpResponse.setHeader("Pragma", "no-cache");
            httpResponse.setDateHeader("Expires", 0);
            httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }

    @Override
    public void destroy() {

    }
}