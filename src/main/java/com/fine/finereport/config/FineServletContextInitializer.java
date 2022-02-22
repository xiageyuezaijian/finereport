package com.fine.finereport.config;


import com.fr.startup.FineWebApplicationInitializer;
import org.springframework.boot.web.servlet.ServletContextInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;


/**
 * @author mly
 * @description
 * @date 2021/3/29
 */
public class FineServletContextInitializer implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        FineWebApplicationInitializer initializer = new FineWebApplicationInitializer();
        initializer.onStartup(servletContext);
    }
}
