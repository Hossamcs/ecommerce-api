package gov.iti.jets.rest.controller;

import gov.iti.jets.repositories.entities.Category;
import gov.iti.jets.repositories.entities.Product;
import gov.iti.jets.rest.Dto.CategoryDto;
import gov.iti.jets.rest.exception.RestException;
import gov.iti.jets.services.CategoryService;
import gov.iti.jets.services.Impl.CategoryServiceImpl;
import gov.iti.jets.services.Impl.ProductServiceImpl;
import gov.iti.jets.services.ProductService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("categories")
@Produces({"application/json", "application/xml"})
public class CategoryController {
    private final CategoryService categoryService = new CategoryServiceImpl();
    private final ProductService productService=new ProductServiceImpl();
    private Category existCategory;

    @POST
    public Response addNewCategory(CategoryDto category) throws RestException {
        try {
            existCategory = new Category(category.getName());
            categoryService.addNewCategory(existCategory);
            return Response.ok().build();
        } catch (Exception e) {
            throw new RestException(" Fail to add Category",e);
        }
    }

    @DELETE
    @Path("{categoryId}")
    public Response deleteCategory(@PathParam("categoryId") int categoryId) throws RestException {
        try{
            existCategory= categoryService.getCategoryById( categoryId );
            List<Product> products = categoryService.getProductsOfCategory( categoryId );
            for(Product product: products){
                productService.deleteCategoryFromProduct(product,existCategory);
            }
            categoryService.deleteCategory(existCategory);

            return Response.ok().build();

        }catch ( Exception e ){
            throw new RestException(  "fail to delete category",e );
        }
    }

}
