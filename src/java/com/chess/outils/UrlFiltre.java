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
        
        String path = req.getRequestURI();
        
        if(path.endsWith(".css") || path.endsWith(".js") || path.endsWith(".jsp") || path.endsWith(".jpg") || path.endsWith(".png") || path.endsWith(".gif")){
            chain.doFilter(request, response);
        }
        else{
            String[] controles = req.getRequestURI().split("/");
            String cible = "";
            if(controles.length > 2){
                
                if(controles[2].equals("run")){
                    if(controles.length > 3) cible = controles[3];
                }
                else cible = controles[2];
                
                request.getRequestDispatcher("/run/"+cible).forward(request, response);
                
            }
            else request.getRequestDispatcher("/run").forward(request, response);
        }
        
    }

    @Override
    public void destroy() {
        
    }
    
}
