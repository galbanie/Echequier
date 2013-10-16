/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chess.outils;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author galbanie
 */
public class UrlFiltre implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        //String path = req.getRequestURI().substring(req.getContextPath().length());
        
        String path = req.getRequestURI();
        
        if(path.endsWith(".css") || path.endsWith(".js") || path.endsWith(".jsp")){
            chain.doFilter(request, response);
        }
        else{
            //request.getRequestDispatcher("/run/").forward(request, response);
            String[] controles = req.getRequestURI().split("/");
            if(controles.length > 2)request.getRequestDispatcher("/run/"+controles[2]).forward(request, response);
            else request.getRequestDispatcher("/run").forward(request, response);
        }
        
    }

    @Override
    public void destroy() {
        
    }
    
}
