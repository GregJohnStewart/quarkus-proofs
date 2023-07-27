package org.acme;

import io.quarkus.oidc.IdToken;
import io.quarkus.oidc.RefreshToken;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.jwt.JsonWebToken;

import static java.util.Objects.requireNonNull;

@Path("/some-page")
public class SomePage {
    
    /**
     * Injection point for the ID Token issued by the OpenID Connect Provider
     */
    @Inject
    @IdToken
    JsonWebToken idToken;
    
    /**
     * Injection point for the Access Token issued by the OpenID Connect Provider
     */
    @Inject
    JsonWebToken accessToken;
    
    /**
     * Injection point for the Refresh Token issued by the OpenID Connect Provider
     */
    @Inject
    RefreshToken refreshToken;

    private final Template page;

    public SomePage(Template page) {
        this.page = requireNonNull(page, "page is required");
    }
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        return page.data("name", null);
    }
    
    /**
     *
     *
     * [at_hash, sub, raw_token, iss, groups, typ, sid, aud, upn, azp, auth_time, exp, session_state, iat, jti]
     *
     * Important claims:
     * sub = user's id
     * upn = User's Principal Name
     *
     *
     *
     *
     *
     * @return
     */
    @GET
    @Path("admin")
    @RolesAllowed("admin")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getAdmin() {
        return page.data("name", this.idToken.getClaim("upn"));
    }

}
