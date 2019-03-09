package io.weli.spring.undertow;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.handlers.PathHandler;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;
import io.undertow.servlet.api.InstanceFactory;
import io.undertow.servlet.api.ListenerInfo;
import io.undertow.servlet.api.ServletInfo;
import io.undertow.servlet.util.ImmediateInstanceFactory;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Sample {
    public static void main(String[] args) throws Exception {
        ServletInfo servlet = Servlets.servlet("spring-servlet", DispatcherServlet.class)
                .addInitParam("contextConfigLocation", "classpath:spring-servlet.xml")
                .addMapping("/*")
                .setLoadOnStartup(1);

        DeploymentInfo deployment = Servlets.deployment()
                .setClassLoader(Sample.class.getClassLoader())
                .setContextPath("/")
                .setDeploymentName("resteasy-spring-undertow.war")
                .addServlet(servlet);

        DeploymentManager manager = Servlets.defaultContainer().addDeployment(deployment);
        manager.deploy();

        PathHandler path = Handlers.path(Handlers.redirect("/"))
                .addPrefixPath("/", manager.start());

        Undertow server = Undertow.builder()
                .addHttpListener(8080, "localhost")
                .setHandler(path)
                .build();

        server.start();

    }
}
