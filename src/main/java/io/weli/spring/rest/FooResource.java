package io.weli.spring.rest;

import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/foo")
@Controller
public class FooResource {
   @GET
   public String foo() {
      return "foo";
   }
}
