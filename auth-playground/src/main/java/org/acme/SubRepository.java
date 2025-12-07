package org.acme;


import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
@ApplicationScoped
public class SubRepository implements PanacheRepository<Sub> {
	
	public static final UUID SUB_UUID = UUID.randomUUID();
	public static final String SUB_SECRET = UUID.randomUUID().toString();
	
	
	@Transactional
	void onStart(
		@Observes
		StartupEvent ev
	) {
		Sub sub = new Sub(SUB_UUID, BcryptUtil.bcryptHash(SUB_SECRET));
		
		this.persist(sub);
		log.info("Sub Persisted: {}", sub);
	}
}
