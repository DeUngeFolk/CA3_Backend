package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.AnimalFactDTO;
import facades.AnimalFactFacade;
import utils.EMF_Creator;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("animalfact")
public class AnimalFactResource {


    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final AnimalFactFacade FACADE =  AnimalFactFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";

    }



    @Path("facthistory/save/{user}")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response saveFactToHistory(@PathParam("user")String user, String factDTO){
        AnimalFactDTO animalFactDTO = GSON.fromJson(factDTO,AnimalFactDTO.class);
        FACADE.addFactToHistory(user, animalFactDTO);

        return Response.ok().entity(GSON.toJson(animalFactDTO)).build();
    }

}
