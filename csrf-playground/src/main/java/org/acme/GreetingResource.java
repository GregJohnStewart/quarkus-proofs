package org.acme;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "Hello from Quarkus REST";
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String helloPost() {
		return "Hello from Quarkus REST";
	}
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public String helloDelete() {
		return "Hello from Quarkus REST";
	}
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	public String helloPut() {
		return "Hello from Quarkus REST";
	}
	@PATCH
	@Produces(MediaType.TEXT_PLAIN)
	public String helloPatch() {
		return "Hello from Quarkus REST";
	}
}
