package sn.dev.examenjeeangularditi4s4.rest;

import sn.dev.examenjeeangularditi4s4.dao.CategorieRepository;
import sn.dev.examenjeeangularditi4s4.entity.Categorie;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategorieRest {

    private CategorieRepository categorieRepository = new CategorieRepository();

    @GET
    public Response getAllCategories() {
        List<Categorie> categories = categorieRepository.selectAllCategories();
        return Response.ok(categories).build();
    }

    @POST
    public Response addCategorie(Categorie categorie) {
        categorieRepository.insertCategorie(categorie);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateCategorie(@PathParam("id") int id, Categorie categorie) {
        categorie.setId(id);
        categorieRepository.updateCategorie(categorie);
        return Response.ok(categorie).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCategorie(@PathParam("id") int id) {
        categorieRepository.deleteCategorie(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/{id}")
    public Response getCategorieById(@PathParam("id") int id) {
        Categorie categorie = categorieRepository.getElementByID(id);
        if (categorie == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(categorie).build();
    }
}
