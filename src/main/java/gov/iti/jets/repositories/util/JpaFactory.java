package gov.iti.jets.repositories.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaFactory {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory( "restApi" );


    public static EntityManager createEntityManager(){
        return emf.createEntityManager();
    }

    public static void main(String[] args) {
        JpaFactory.createEntityManager();
    }

}
