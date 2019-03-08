package io.weli.spring.undertow;

import io.undertow.servlet.api.DeploymentInfo;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;

public class UndertowSpringJaxrsServer extends UndertowJaxrsServer {

   public DeploymentInfo undertowDeployment(ResteasyDeployment deployment, String mapping) {
      if (mapping == null) mapping = "/";
      if (!mapping.startsWith("/")) mapping = "/" + mapping;
      if (!mapping.endsWith("/")) mapping += "/";
      mapping = mapping + "*";
      String prefix = null;
      if (!mapping.equals("/*")) prefix = mapping.substring(0, mapping.length() - 2);

      // TODO: add implementation
      return null;

   }
}
