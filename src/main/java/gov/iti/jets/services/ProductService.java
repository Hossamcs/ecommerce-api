package gov.iti.jets.services;

import gov.iti.jets.repositories.entities.Category;
import gov.iti.jets.repositories.entities.Product;

import java.util.List;

public interface ProductService {

    public void addNewProduct(Product product);
    public List<Product> getAllProducts();
    public Product getProductById(int id);
    public  void updateProduct(Product product);
    public void deleteProduct(int id);
    public void addCategoryToProduct(Product product, Category category);
    public void deleteCategoryFromProduct(Product product,Category category);
}
