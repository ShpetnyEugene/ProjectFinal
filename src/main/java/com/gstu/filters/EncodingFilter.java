package com.gstu.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter ("/*")
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");

        HttpServletRequest req = (HttpServletRequest)servletRequest;
        String path = req.getRequestURI().substring(req.getContextPath().length());

        // String path = req.getRequestURI();
        // System.out.println(">>>>"+path+" "+req.getRequestURI());
        if (path.startsWith("/resources/")) {
            // Just let container's default servlet do its job.
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletRequest.getRequestDispatcher("/" + path).forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
