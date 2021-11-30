package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.CatFactFacade;
import facades.DogFactFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.ExecutionException;


@Path("dogfact")
public class DogFactResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final DogFactFacade FACADE =  DogFactFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }

    @Path("dog")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getFact() throws ExecutionException, InterruptedException {

        return Response.ok().entity(GSON.toJson(FACADE.getDogFact())).build();
    }
}
