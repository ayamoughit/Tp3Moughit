package ma.emsi.moughit.tp3moughit.ressources;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import ma.emsi.moughit.tp3moughit.llm.GuideTouristiqueService;

@Path("/guide")
public class GuideTouristiqueResource {

    @Inject
    private GuideTouristiqueService guideService;

    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public String villeOuPays(@PathParam("ville_ou_pays") String lieu) {
        return guideService.getGuide(lieu);
    }
}
