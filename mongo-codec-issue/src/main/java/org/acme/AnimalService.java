package org.acme;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
public class AnimalService {
    @Inject
    MongoClient mongoClient;
    
    
    public MongoCollection<Animal> getCollection(){
        return mongoClient.getDatabase("taxonomy").getCollection("animals", Animal.class);
    }
}
