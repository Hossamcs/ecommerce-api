package gov.iti.jets.repositories;


import gov.iti.jets.repositories.entities.User;
import jakarta.persistence.EntityManager;

public class UserRepository extends AbstractRepository<User>{
    public UserRepository( EntityManager entityManager ) {
        super( entityManager );
        this.setClazz( User.class );
    }
}
