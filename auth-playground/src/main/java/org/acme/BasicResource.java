package org.acme;

import io.quarkus.oidc.BearerTokenAuthentication;
import io.quarkus.vertx.http.runtime.security.annotation.BasicAuthentication;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

@RequestScoped
@Slf4j
@RolesAllowed("basicUser")
//@Authenticated
@BasicAuthentication
@Path("/basic")
public class BasicResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }
}
