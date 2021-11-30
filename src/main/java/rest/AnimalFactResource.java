package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.AnimalFactDTO;
import facades.*;
import utils.EMF_Creator;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.concurrent.ExecutionException;

@Path("animalfact")
public class AnimalFactResource {


    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final AnimalFactFacade ANIMAL_FACT_FACADE =  AnimalFactFacade.getFacadeExample(EMF);
    private static final DogFactFacade DOG_FACT_FACADE =  DogFactFacade.getFacadeExample(EMF);
    private static final FoxFactFacade FOX_FACT_FACADE =  FoxFactFacade.getFacadeExample(EMF);
    private static final KoalaFactFacade KOALA_FACT_FACADE =  KoalaFactFacade.getFacadeExample(EMF);
    private static final CatFactFacade CAT_FACT_FACADE =  CatFactFacade.getFacadeExample(EMF);

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";

    }

    @Path("dog")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getDogFact() throws ExecutionException, InterruptedException {

        return Response.ok().entity(GSON.toJson(DOG_FACT_FACADE.getDogFact())).build();
    }

    @Path("fox")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getFoxFact() throws ExecutionException, InterruptedException {

        return Response.ok().entity(GSON.toJson(FOX_FACT_FACADE.getFoxFact())).build();
    }

    @Path("koala")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getKoalaFact() throws ExecutionException, InterruptedException {

        return Response.ok().entity(GSON.toJson(KOALA_FACT_FACADE.getKoalaFact())).build();
    }

    @Path("cat")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getCatFact() throws ExecutionException, InterruptedException {

        return Response.ok().entity(GSON.toJson(CAT_FACT_FACADE.getCatFact())).build();
    }

    @Path("facthistory/save/{user}")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response saveFactToHistory(@PathParam("user")String user, String factDTO){
        AnimalFactDTO animalFactDTO = GSON.fromJson(factDTO,AnimalFactDTO.class);
        ANIMAL_FACT_FACADE.addFactToHistory(user, animalFactDTO);

        return Response.ok().entity(GSON.toJson(animalFactDTO)).build();
    }

}
