package org.training.microservice.msorder.security;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/*")
public class MyFilter implements Filter {
    @Override
    public void doFilter(final ServletRequest servletRequestParam,
                         final ServletResponse servletResponseParam,
                         final FilterChain filterChainParam) throws IOException, ServletException {
        System.out.println("My Filter running .............");
        filterChainParam.doFilter(servletRequestParam,
                                  servletResponseParam);
    }
}
