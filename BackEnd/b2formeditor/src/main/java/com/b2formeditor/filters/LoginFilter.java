package com.b2formeditor.filters;

import com.b2formeditor.models.authenticationmodels.LoginCredentials;
import com.b2formeditor.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by jolde on 02.05.2017.
 */
@Component
@Order(1)
public class LoginFilter implements Filter {
    @Autowired
    private AuthenticationService service;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        HttpSession session = httpRequest.getSession(true);
        String email = httpRequest.getParameter("email");
        String password = httpRequest.getParameter("password");
        LoginCredentials credentials = new LoginCredentials(email, password);

        if (session.getAttribute("credentials") != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            if (service.validCredentials(credentials)) {
                session.setAttribute("credentials", credentials);
                httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
                httpResponse.setHeader("Pragma", "no-cache");
                httpResponse.setDateHeader("Expires", 0);
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
