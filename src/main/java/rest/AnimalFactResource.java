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


    @Context
    SecurityContext securityContext;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";

    }



    @Path("facthistory/save")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @RolesAllowed("user")
    public Response saveFactToHistory(String factDTO){
        String thisuser = securityContext.getUserPrincipal().getName();
        AnimalFactDTO animalFactDTO = GSON.fromJson(factDTO,AnimalFactDTO.class);
        FACADE.addFactToHistory(thisuser, animalFactDTO);

        return Response.ok().build();
    }

}
