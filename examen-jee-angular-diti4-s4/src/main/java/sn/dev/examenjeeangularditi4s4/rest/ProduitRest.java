package sn.dev.examenjeeangularditi4s4.rest;

import sn.dev.examenjeeangularditi4s4.dao.ProduitRepository;
import sn.dev.examenjeeangularditi4s4.entity.Produit;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/produits")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProduitRest {

    private ProduitRepository produitRepository = new ProduitRepository();

    @GET
    public Response getAllProduits() {
        List<Produit> produits = produitRepository.selectAllProduits();
        return Response.ok(produits).build();
    }

    @POST
    public Response addProduit(Produit produit) {
        produitRepository.insertProduit(produit);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateProduit(@PathParam("id") int id, Produit produit) {
        produit.setId(id);
        produitRepository.updateProduit(produit);
        return Response.ok(produit).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduit(@PathParam("id") int id) {
        produitRepository.deleteProduit(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/{id}")
    public Response getProduitById(@PathParam("id") int id) {
        Produit produit = produitRepository.getElementByID(id);
        if (produit == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(produit).build();
    }
}
