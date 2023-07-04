package com.acme;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.apache.camel.CamelContext;
import org.apache.camel.quarkus.test.CamelQuarkusTestSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
@ApplicationScoped
public class RoutesTest extends CamelQuarkusTestSupport {
	
	@Inject
	CamelContext context;
	
	@BeforeEach
	public void setup(){
		context.start();
	}
	
	@Test
	public void testOne(){
		assertEquals(3, context.getRoutes().size());
	}
	@Test
	public void testTwo(){
		assertEquals(3, context.getRoutes().size());
	}
	
}
