package sn.dev.examenjeeangularditi4s4.rest;

import sn.dev.examenjeeangularditi4s4.dao.UserRepository;
import sn.dev.examenjeeangularditi4s4.entity.User;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserRest {

    private UserRepository userRepository = new UserRepository();

    @GET
    public Response getAllUsers() {
        List<User> users = userRepository.selectAllUsers();
        return Response.ok(users).build();
    }

    @POST
    public Response addUser(User user) {
        userRepository.insertUser(user);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateUser(@PathParam("id") int id, User user) {
        user.setId(id);
        userRepository.updateUser(user);
        return Response.ok(user).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") int id) {
        userRepository.deleteUser(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/{id}")
    public Response getUserById(@PathParam("id") int id) {
        User user = userRepository.getElementByID(id);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(user).build();
    }
}