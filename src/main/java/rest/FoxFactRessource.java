package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import facades.FoxFactFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.ExecutionException;

@Path("foxfact")
public class FoxFactRessource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final FoxFactFacade FACADE =  FoxFactFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }

    @Path("fox")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getFact() throws ExecutionException, InterruptedException {

        return Response.ok().entity(GSON.toJson(FACADE.getFoxFact())).build();
    }

}
