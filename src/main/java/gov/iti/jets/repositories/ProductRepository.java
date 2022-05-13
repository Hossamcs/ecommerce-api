package gov.iti.jets.repositories;

import gov.iti.jets.repositories.entities.Product;
import jakarta.persistence.EntityManager;

public class ProductRepository extends AbstractRepository<Product>{
    public ProductRepository( EntityManager entityManager ) {
        super( entityManager );
        this.setClazz( Product.class );
    }
}
