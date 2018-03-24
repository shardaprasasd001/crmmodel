package org.tsm;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
@EnableJSONDoc
@Import({ WebConfig.class, AppConfig.class, SwaggerConfig.class })
public class CrmmodelApplication extends SpringBootServletInitializer {

    public static void main(final String[] args) {
        SpringApplication.run(CrmmodelApplication.class, args);
    }

    public void onStartup(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
        dispatcherServlet.register(WebConfig.class, AppConfig.class, SwaggerConfig.class);
        configureServlet(servletContext, dispatcherServlet);
    }

    private void configureServlet(ServletContext servletContext,
            AnnotationConfigWebApplicationContext dispatcherServlet) {
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",
                new DispatcherServlet(dispatcherServlet));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
