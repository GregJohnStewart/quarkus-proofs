package org.acme;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.config.ConfigProvider;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@QuarkusTestResource(value = KeycloakServerManager.class)
public class KeycloakTest {
    
    
    private final String keycloakAdminName = ConfigProvider.getConfig().getValue("test.keycloak.adminName", String.class);
    private final String keycloakAdminPass = ConfigProvider.getConfig().getValue("test.keycloak.adminPass", String.class);
    private final String keycloakRealm = ConfigProvider.getConfig().getValue("service.externalAuth.realm", String.class);
    private final String keycloakClientId = ConfigProvider.getConfig().getValue("service.externalAuth.clientId", String.class);
    private final String keycloakClientSecret = ConfigProvider.getConfig().getValue("service.externalAuth.clientSecret", String.class);
    
    
    @Test
    public void testHelloEndpoint() {
    
    }
    
    

}