package gov.iti.jets.rest.controller;


import gov.iti.jets.repositories.entities.Category;
import gov.iti.jets.repositories.entities.Product;
import gov.iti.jets.rest.Dto.ProductDto;
import gov.iti.jets.rest.Dto.ResponseProductDto;
import gov.iti.jets.rest.Mapper.RestMapper;
import gov.iti.jets.rest.exception.RestException;
import gov.iti.jets.services.CategoryService;
import gov.iti.jets.services.Impl.CategoryServiceImpl;
import gov.iti.jets.services.Impl.ProductServiceImpl;
import gov.iti.jets.services.ProductService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;


@Path("products")
@Produces({"application/json", "application/xml"})
@Consumes("application/json")
public class ProductController {
    private final ProductService productService = new ProductServiceImpl();
    private final CategoryService categoryService=new CategoryServiceImpl();

    @POST
    public Response addNewProduct(ProductDto productDto) throws RestException {
        try {
            Product product = new Product(productDto.getName(), productDto.getDescription(), productDto.getPrice());
            productService.addNewProduct(product);
            return Response.ok().build();
        } catch (Exception e) {
            throw new RestException("fail to add product",e);
        }
    }
    @GET
    @Path("{productId}")
    public Response getProductById(@PathParam("productId") int productId, @Context UriInfo uriInfo) throws RestException {
        try{
            Product existProduct = productService.getProductById(productId);
            ResponseProductDto product = RestMapper.mapProductToResponse( existProduct );
            return Response.ok().entity(product).build();
        } catch ( Exception e ){
            throw new RestException(  "fail to found product",e );
        }
    }
    @PUT
    @Path("{productId}")
    public Response updateProduct(@PathParam("productId") int productId, ProductDto productDto) throws RestException {
        try {
            Product product = productService.getProductById( productId );
            product.setName(productDto.getName());
            product.setDescription(productDto.getDescription());
            product.setPrice(productDto.getPrice());
            productService.updateProduct( product );
            return Response.ok().entity(product).build();
        } catch (Exception e) {
            throw new RestException( "fail to update",e );
        }
    }
    @DELETE
    @Path( "{productId}" )
    public Response deleteProduct(@PathParam( "productId" ) int productId) throws RestException {
        try{
            Product product = productService.getProductById( productId );
            productService.deleteProduct(productId);
            return Response.ok().entity(product).build();
        }catch(Exception e){
            throw new RestException( "fail to delete product",e );
        }
    }
    @POST
    @Path("{productId}/categories/{categoryId}")
    public Response addCategoryToProduct(@PathParam("productId") int productId, @PathParam("categoryId") int categoryId) throws RestException {
        try {
            Product existProduct = productService.getProductById( productId );
            Category existCategory = categoryService.getCategoryById( categoryId );
            productService.addCategoryToProduct(existProduct, existCategory);
            return Response.ok().build();

        } catch (Exception e) {
            throw new RestException( "fail to add product",e);
        }
    }

}
