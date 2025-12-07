package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class BasicResourceTest {
	
	@Test
	void testEndpoint() {
		given()
			.log().all()
			.when()
			.auth().preemptive().basic(SubRepository.SUB_UUID.toString(), SubRepository.SUB_SECRET)
			.get("/basic")
			.then()
			.statusCode(200);
	}
	
}