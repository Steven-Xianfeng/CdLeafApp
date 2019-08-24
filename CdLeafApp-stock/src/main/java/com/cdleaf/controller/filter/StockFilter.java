package com.cdleaf.controller.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/*", filterName = "stockFilter")
@Component
public class StockFilter implements Filter {


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println(" Stock Filter ::: Execute ...... " + ((HttpServletRequest)request).getRequestURI());

        chain.doFilter(request,response);



        System.out.println(" Stock Filter ::: Execute ......2  " + ((HttpServletRequest)request).getRequestURI());
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
