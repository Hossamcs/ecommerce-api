package gov.iti.jets.rest.controller;


import gov.iti.jets.repositories.entities.CartLineItem;
import gov.iti.jets.repositories.entities.Product;
import gov.iti.jets.repositories.entities.User;
import gov.iti.jets.rest.Dto.ChooseProductDto;
import gov.iti.jets.rest.Dto.UserDto;
import gov.iti.jets.rest.Mapper.RestMapper;
import gov.iti.jets.rest.exception.RestException;
import gov.iti.jets.services.CartService;
import gov.iti.jets.services.Impl.CartServiceImpl;
import gov.iti.jets.services.Impl.OrderServiceImpl;
import gov.iti.jets.services.Impl.ProductServiceImpl;
import gov.iti.jets.services.Impl.UserServiceImpl;
import gov.iti.jets.services.OrderService;
import gov.iti.jets.services.ProductService;
import gov.iti.jets.services.UserService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

@Path("users")
@Produces({"application/json", "application/xml"})
@Consumes("application/json")
public class UserController {

    private final UserService userService = new UserServiceImpl();
    private final ProductService productService = new ProductServiceImpl();
    private final CartService cartService = new CartServiceImpl();
    private final OrderService orderService = new OrderServiceImpl();

    @GET
    @Path("{userId}")
    public Response getUserById(@PathParam("userId") int userId) {
        User user = userService.getUserById(userId);
        return Response.ok().entity(RestMapper.mapUserToDto(user)).build();
    }

    @GET
    public Response getAllUsers() {
        List<UserDto> users = userService.getAllUsers()
                .stream()
                .map(user -> RestMapper.mapUserToDto(user))
                .collect(Collectors.toList());
        return Response.ok().entity(users).build();
    }

    @POST
    public Response addNewUser(User user) throws RestException {
        try {
            userService.addNewUser(user);
            return Response.ok().build();
        } catch (Exception e) {
            throw new RestException("Fail to add User", e);
        }
    }

    @PUT
    @Path("{id}")
    public Response updateUser(@PathParam("id") int id, User user) throws RestException {
        try {
            User existUser = userService.getUserById(id);
            existUser.setEmail(user.getEmail());
            existUser.setFirstName(user.getFirstName());
            existUser.setLastName(user.getLastName());
            existUser.setRole(user.getRole());
            userService.updateUSer(existUser);
            return Response.ok().entity(RestMapper.mapUserToDto(existUser)).build();
        } catch (Exception e) {
            throw new RestException("Fail to update", e);
        }
    }

    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") int userId) throws RestException {

        try {
            User existUser = userService.getUserById(userId);
            userService.deleteUser(existUser);
            return Response.ok("Deleted").build();
        } catch (Exception e) {
            throw new RestException("No Such user Found", e);
        }
    }

    @POST
    @Path("{userId}/cart")
    public Response addProductToCart(@PathParam("userId") int userId, ChooseProductDto dto) {
        Product product = productService.getProductById(dto.getProductId());
        CartLineItem item = new CartLineItem();
        item.setProduct(product);
        item.setQuantity(dto.getQuantity());
        cartService.addProductToCart(userId, item);
        return Response.ok().entity("success to add item").build();
    }

    @DELETE
    @Path("{userId}/cart/{productId}")
    public Response removeProductFromCart(@PathParam("userId") int userId, @PathParam("productId") int itemId) throws RestException {

        try {
            cartService.deleteProductFromCart(userId, itemId);
            return Response.ok().entity("success to delete Product").build();

        } catch (Exception e) {
            throw new RestException("Can't delete product", e);
        }

    }

    @DELETE
    @Path("{userId}/cart")
    public Response emptyUserCart(@PathParam("userId") int userId) throws RestException {

        try {

            cartService.emptyCart(userId);
            return Response.ok().entity("success to delete your cart").build();

        } catch (Exception e) {
            throw new RestException("fail to empty cart", e);
        }

    }

    @POST
    @Path("{userId}/orders")
    public Response placeOrder(@PathParam("userId") int userId) throws RestException {
        try {
            User user = userService.getUserById(userId);
            orderService.addNewOrder(user);
            return Response.ok().entity("success to add your order").build();
        } catch (Exception e) {
            throw new RestException("fail to place order", e);
        }
    }


}
