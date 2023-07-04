package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.UriBuilder;
import org.apache.http.client.utils.URIBuilder;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class UriBuilderTest {
    
    private static final String BASE_URL = "http://localhost:6851/some/endpoint";
    private static final String REDIRECT_URL_PARAM_NAME = "redirect_url";
    private static final String REDIRECT_URL;
    
    static {
        try {
            REDIRECT_URL = new URIBuilder("http://localhost:3185/some/other/endpoint")
                               .setParameter("redirect", "/some/endpoint?another=query")
                               .build().toString();
        } catch(URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    
    //NOTE:: injecting a logger failed to find bean
    private static final Logger LOG = Logger.getLogger(UriBuilderTest.class.getName());
    
    @Test
    public void testUriBuilder() throws URISyntaxException {
        UriBuilder uriBuilder = UriBuilder.fromUri(BASE_URL);
        uriBuilder.queryParam(REDIRECT_URL_PARAM_NAME, REDIRECT_URL);
        
        String result = uriBuilder.build().toString();
        
        LOG.log(Level.INFO, "Uri builder: {0}", uriBuilder.toString());
        LOG.log(Level.INFO, "Uri builder class: {0}", uriBuilder.getClass().toString());
        
        assertEquals(
            new URIBuilder(BASE_URL).setParameter(REDIRECT_URL_PARAM_NAME, REDIRECT_URL).build().toString(),
            result
        );
    }

}