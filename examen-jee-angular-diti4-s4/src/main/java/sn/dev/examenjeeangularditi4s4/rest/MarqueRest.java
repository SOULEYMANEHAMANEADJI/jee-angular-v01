package sn.dev.examenjeeangularditi4s4.rest;

import sn.dev.examenjeeangularditi4s4.dao.MarqueRepository;
import sn.dev.examenjeeangularditi4s4.entity.Marque;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/marques")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MarqueRest {

    private MarqueRepository marqueRepository = new MarqueRepository();

    @GET
    public Response getAllMarques() {
        List<Marque> marques = marqueRepository.selectAllMarques();
        return Response.ok(marques).build();
    }

    @POST
    public Response addMarque(Marque marque) {
        marqueRepository.insertMarque(marque);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateMarque(@PathParam("id") int id, Marque marque) {
        marque.setId(id);
        marqueRepository.updateMarque(marque);
        return Response.ok(marque).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMarque(@PathParam("id") int id) {
        marqueRepository.deleteMarque(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/{id}")
    public Response getMarqueById(@PathParam("id") int id) {
        Marque marque = marqueRepository.getElementByID(id);
        if (marque == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(marque).build();
    }
}
