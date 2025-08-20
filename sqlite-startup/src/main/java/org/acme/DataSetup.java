package org.acme;

import io.quarkus.runtime.Startup;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class DataSetup {
	
	@Transactional
	@Startup
	void start() {
		log.info("Starting DataSetup");
		MyEntity.count(); // <-- fails here
		new MyEntity().persist(); // <-- works if above line not present
	}
	
}
