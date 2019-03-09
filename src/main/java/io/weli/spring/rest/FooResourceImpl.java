package io.weli.spring.rest;

import io.weli.spring.def.FooResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Component
public class FooResourceImpl implements FooResource {
   public String foo() {
      return "foo";
   }
}
