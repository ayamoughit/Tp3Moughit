package ma.emsi.moughit.tp3moughit.ressources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/guide")
public class GuideTouristiqueResource {

    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public String[] villeOuPays(@PathParam("ville_ou_pays") String lieu) {
        // JAX-RS convertit automatiquement le tableau en JSON
        return new String[]{lieu};
    }
}
