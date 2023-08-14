package org.acme;

import io.quarkus.oidc.IdToken;
import org.eclipse.microprofile.jwt.JsonWebToken;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.SecurityContext;

public abstract class RestInterface {
	
	@Inject
	@IdToken
	JsonWebToken jwt;
	
	@Context
	SecurityContext securityContext;
	
	protected boolean hasJwt() {
		return this.jwt != null && this.jwt.getClaimNames() != null;
	}
	
	protected void logRequestAndProcessEntity() {
		if (!this.hasJwt()) {
			System.out.println("Processing request with no JWT; ssh: " + this.securityContext.isSecure());
		} else {
			System.out.println(
				"Processing request with JWT; User:"+
				this.securityContext.getUserPrincipal().getName() +
				" ssh: " +
				this.securityContext.isSecure() +
				" jwtIssuer: " +
				jwt.getIssuer() +
				"jwt: " + jwt.getRawToken()
			);
			if (!this.securityContext.isSecure()) {
				System.out.println("Request with JWT made without HTTPS");
			}
			
		}
	}
	
	@PostConstruct
	void initialLogAndEntityProcess(){
		this.logRequestAndProcessEntity();
	}
}
