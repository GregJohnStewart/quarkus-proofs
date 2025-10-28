package org.acme;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/sub/json")
public class JsonSub {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "Hello from GET";
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String helloPost() {
		return "Hello from POST";
	}
	
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public String helloDelete() {
		return "Hello from DELETE";
	}
	
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	public String helloPut() {
		return "Hello from PUT";
	}
	
	@PATCH
	@Produces(MediaType.TEXT_PLAIN)
	public String helloPatch() {
		return "Hello from PATCH";
	}
}
