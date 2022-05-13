package gov.iti.jets.services;

import gov.iti.jets.repositories.entities.Category;
import gov.iti.jets.repositories.entities.Product;

import java.util.List;

public interface CategoryService {
    public Category getCategoryById(int  categoryId);
    public List<Category> getAllCategories();
    public void addNewCategory(Category  category);
    public void deleteCategory(Category category);
    public List<Product> getProductsOfCategory(int categoryId);
}
