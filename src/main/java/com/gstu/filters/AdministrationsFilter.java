package com.gstu.filters;


import com.gstu.models.Role;
import com.gstu.models.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter("/admin/*")
public class AdministrationsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        User user = (User) req.getSession().getAttribute("user");


        if(user != null && user.getRole() == Role.ADMIN){
            filterChain.doFilter(req, resp);
        }else{
            resp.sendRedirect("/booking/stations");
        }
    }

    @Override
    public void destroy() {
    }
}
