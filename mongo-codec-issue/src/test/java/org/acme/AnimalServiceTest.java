package org.acme;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class AnimalServiceTest {
    
    @Inject
    AnimalService animalService;

    @Test
    public void testAnimalService() {
        Animal<?> cat = new Cat(9);
        
        MongoCollection<Animal> collection = animalService.getCollection();
        
        InsertOneResult result = collection.insertOne(cat);
        
        Animal<?> catOut = collection.find(Filters.eq("_id", result.getInsertedId().asObjectId().getValue())).first();
        
        assertEquals(cat.value, catOut.value);
    }

}