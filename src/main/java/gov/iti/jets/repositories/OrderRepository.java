package gov.iti.jets.repositories;

import gov.iti.jets.repositories.entities.Order;
import jakarta.persistence.EntityManager;

public class OrderRepository extends AbstractRepository<Order>{
    public OrderRepository( EntityManager entityManager ) {
        super( entityManager );
        this.setClazz( Order.class );
    }

}
