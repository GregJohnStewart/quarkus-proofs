package org.acme;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import org.eclipse.microprofile.config.ConfigProvider;
import org.junit.jupiter.api.Test;

@QuarkusIntegrationTest
public class TestTest {
	
	@Test
	public void testGetConfig(){
		System.out.println("Auth mode: "+ConfigProvider.getConfig().getValue("quarkus.mongodb.connection-string", String.class));
	}
}
