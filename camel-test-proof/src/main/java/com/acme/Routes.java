package com.acme;

import jakarta.enterprise.context.ApplicationScoped;
import org.apache.camel.builder.RouteBuilder;

import static org.apache.camel.builder.endpoint.StaticEndpointBuilders.timer;

@ApplicationScoped
public class Routes extends RouteBuilder {
	
	
	@Override
	public void configure() throws Exception {
		from(timer("foo").period(1000))
			.to("direct:helloLog");
		
		from(timer("direct:helloLog").period(1000))
			.log("hello world")
			.to("direct:bar");
		
		from(timer("direct:bar").period(1000))
			.log("done");
		
	}
}
