package gov.iti.jets.services.Impl;

import gov.iti.jets.repositories.ProductRepository;
import gov.iti.jets.repositories.entities.Category;
import gov.iti.jets.repositories.entities.Product;
import gov.iti.jets.repositories.util.JpaFactory;
import gov.iti.jets.services.ProductService;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    private EntityManager manager;
    private ProductRepository repo;

    @Override
    public void addNewProduct(Product product) {
        manager = JpaFactory.createEntityManager();
        repo = new ProductRepository(manager);
        if (!Objects.isNull(product)) {
            manager.getTransaction().begin();
            repo.create(product);
            manager.getTransaction().commit();
            manager.close();
        }
    }

    @Override
    public List<Product> getAllProducts() {
        manager = JpaFactory.createEntityManager();
        repo = new ProductRepository(manager);
        manager.getTransaction().begin();
        List<Product> products = repo.findAll();
        manager.getTransaction().commit();
        manager.close();
        return products;
    }

    @Override
    public Product getProductById(int id) {
        manager = JpaFactory.createEntityManager();
        repo = new ProductRepository(manager);
        Optional<Product> product = repo.findOne(id);
        manager.close();
        if (product.isPresent()) {
            return product.get();
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    public void updateProduct(Product product) {
        if (!Objects.isNull(product)) {
            manager = JpaFactory.createEntityManager();
            repo = new ProductRepository(manager);
            manager.getTransaction().begin();
            repo.update(product);
            manager.getTransaction().commit();
            manager.close();
        }
    }

    @Override
    public void deleteProduct(int id) {
        manager = JpaFactory.createEntityManager();
        repo = new ProductRepository(manager);
        manager.getTransaction().begin();
        repo.deleteById(id);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void addCategoryToProduct(Product product, Category category) {
        if(!Objects.isNull(product)&&!Objects.isNull(category)){
        product.addCategoryToProduct(category);
        updateProduct(product);
        }
    }

    @Override
    public void deleteCategoryFromProduct(Product product, Category category) {
        if(!Objects.isNull(product)&&!Objects.isNull(category)){
            product.removeCategoryFromProduct(category);
            updateProduct(product);
        }
    }
}
