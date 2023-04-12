package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello from RESTEasy Reactive"));
    }
    @Inject
	DataSource ds;
	
	@Test
	public void test() throws SQLException {
		log.info("Successfully ran test setup");
		
		try(Connection db = ds.getConnection()){
			try(
					CallableStatement stmt = db.prepareCall("SELECT DB_NAME();");
			){
				stmt.execute();
				ResultSet dbResult = stmt.getResultSet();
				dbResult.next();
				log.info("Database used: {}", dbResult.getString(1));
			}
		
			try(
					CallableStatement tstmt = db.prepareCall("SELECT * FROM master.INFORMATION_SCHEMA.TABLES;");
			){
				tstmt.execute();
				
				ResultSet tablesResult = tstmt.getResultSet();
				ResultSetMetaData rsm = tablesResult.getMetaData();
				
				List<String> cols = new ArrayList<>();
				for(int i = 1; i < rsm.getColumnCount(); i++) {
					cols.add(rsm.getColumnName(i));
				}
				log.info("Columns: {}", cols);
				
				
				while(tablesResult.next()) {
					Map<String, Object> results = new HashMap<>();
					
					for(String curCol : cols) {
						results.put(
								curCol, 
								tablesResult.getObject(curCol)
								);
					}
					
					log.info("Table: {}", results);
				}
			}
		}
	}

}
