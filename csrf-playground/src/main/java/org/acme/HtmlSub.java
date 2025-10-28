package org.acme;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;

import static java.util.Objects.requireNonNull;

@Path("/sub/html")
public class HtmlSub {
	
	@GET
	public Response hello() {
		return Response.seeOther(URI.create("/?method=GET")).build();
	}
	
	@POST
	public Response helloPost() {
		return Response.seeOther(URI.create("/?method=POST")).build();
	}
	
	@DELETE
	@Path("/delete")
	public Response helloDelete() {
		return Response.seeOther(URI.create("/?method=DELETE")).build();
	}
	
	@PUT
	@Path("/put")
	public Response helloPut() {
		return Response.seeOther(URI.create("/?method=PUT")).build();
	}
	
	@PATCH
	@Path("/patch")
	public Response helloPatch() {
		return Response.seeOther(URI.create("/?method=PATCH")).build();
	}

}
