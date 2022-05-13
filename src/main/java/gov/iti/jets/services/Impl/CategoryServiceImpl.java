package gov.iti.jets.services.Impl;

import gov.iti.jets.repositories.CategoryRepository;
import gov.iti.jets.repositories.entities.Category;
import gov.iti.jets.repositories.entities.Product;
import gov.iti.jets.repositories.util.JpaFactory;
import gov.iti.jets.services.CategoryService;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.Optional;

public class CategoryServiceImpl implements CategoryService {
    private EntityManager manager;
    private CategoryRepository categoryRepo;

    @Override
    public Category getCategoryById(int categoryId) {
        manager = JpaFactory.createEntityManager();
        categoryRepo = new CategoryRepository(manager);
        Optional<Category> category = categoryRepo.findOne(categoryId);
        manager.close();
        if (category.isPresent())
            return category.get();
        else
            throw new NotFoundException();
    }

    @Override
    public List<Category> getAllCategories() {
        manager = JpaFactory.createEntityManager();
        categoryRepo = new CategoryRepository(manager);
        return categoryRepo.findAll();
    }

    @Override
    public void addNewCategory(Category category) {
        manager = JpaFactory.createEntityManager();
        categoryRepo = new CategoryRepository(manager);
        manager.getTransaction().begin();
        manager.persist(category);
        manager.getTransaction().commit();
        manager.close();

    }

    @Override
    public void deleteCategory(Category category) {
        manager = JpaFactory.createEntityManager();
        categoryRepo = new CategoryRepository(manager);
        manager.getTransaction().begin();
        categoryRepo.deleteById(category.getId());
        manager.getTransaction().commit();
        manager.close();

    }

    @Override
    public List<Product> getProductsOfCategory(int categoryId) {
        manager = JpaFactory.createEntityManager();
        Optional<List<Product>> products = categoryRepo.getProductListOfCategory(manager, categoryId);
        manager.close();
        if (products.isPresent())
            return products.get();
        else
            throw new NotFoundException();
    }
}
