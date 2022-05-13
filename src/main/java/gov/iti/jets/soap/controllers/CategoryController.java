package gov.iti.jets.soap.controllers;

import gov.iti.jets.repositories.entities.Category;
import gov.iti.jets.repositories.entities.Product;
import gov.iti.jets.services.CategoryService;
import gov.iti.jets.services.Impl.CategoryServiceImpl;
import gov.iti.jets.soap.Dtos.CategoryDto;
import gov.iti.jets.soap.Dtos.ProductDto;
import gov.iti.jets.soap.Util.SoapException;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;
import java.util.stream.Collectors;

@WebService
public class CategoryController {

    private final CategoryService categoryService = new CategoryServiceImpl();

    @WebMethod
    public String addNewCategory(CategoryDto newCategory) throws SoapException {
        try {
            Category category = new Category(newCategory.getName());
            categoryService.addNewCategory(category);
            return "success to add Category";
        } catch (Exception e) {
            throw new SoapException("fail to add product", e);
        }
    }

    @WebMethod
    public List<ProductDto> getProductsOfCategory(int categoryId) throws SoapException {
        try {
            List<Product> products = categoryService.getProductsOfCategory(categoryId);
            return products
                    .stream()
                    .map(product -> new ProductDto(product.getId(), product.getDescription(), product.getName(),product.getPrice()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            throw new SoapException("fail to get categories", e);
        }

    }

}
