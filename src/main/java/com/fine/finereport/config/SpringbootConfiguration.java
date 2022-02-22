package com.fine.finereport.config;


import org.apache.catalina.Context;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import java.io.File;

/**
 * @author mly
 * @description
 * @date 2021/3/29
 */
@SpringBootConfiguration
public class SpringbootConfiguration {

    @Value("${file-url}")
    private String url;

    @Bean("listener")
    public FineServletContextInitializer createServletListenerRegistrationBean() {

        return (new FineServletContextInitializer());
    }


    @Bean
    public TomcatServletWebServerFactory tomcatServletWebServerFactory() {
        return new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                File file = new File(url);
                if (file.exists() && file.isDirectory()) {
                    String env = file.getAbsoluteFile().getPath();
                    logger.info("Reset fine webapp dir: " + env);
                    context.setDocBase(env);
                } else {
                    throw new BeanCreationException("Fine webapp dir [env] not found");
                }
            }
        };
    }
}
