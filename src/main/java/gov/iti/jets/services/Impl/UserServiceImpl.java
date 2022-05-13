package gov.iti.jets.services.Impl;

import gov.iti.jets.repositories.ProductRepository;
import gov.iti.jets.repositories.UserRepository;
import gov.iti.jets.repositories.entities.User;
import gov.iti.jets.repositories.util.JpaFactory;
import gov.iti.jets.services.UserService;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private EntityManager manager;
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        manager = JpaFactory.createEntityManager();
        userRepository = new UserRepository(manager);
        manager.getTransaction().begin();
        List users = userRepository.findAll();
        manager.getTransaction().commit();
        manager.close();
        return users;
    }

    @Override
    public User getUserById(int userId) {
        manager = JpaFactory.createEntityManager();
        userRepository = new UserRepository(manager);
        Optional<User> user = userRepository.findOne(userId);
        manager.close();
        if (user.isPresent())
            return user.get();
        else
            throw new NotFoundException();
    }

    @Override
    public void addNewUser(User user) {
        if (!Objects.isNull(user)) {
            manager = JpaFactory.createEntityManager();
            userRepository = new UserRepository(manager);
            manager.getTransaction().begin();
            userRepository.create(user);
            manager.getTransaction().commit();
            manager.close();
        }

    }

    @Override
    public void updateUSer(User user) {
        if (!Objects.isNull(user)) {
            manager = JpaFactory.createEntityManager();
            userRepository = new UserRepository(manager);
            manager.getTransaction().begin();
            userRepository.update(user);
            manager.getTransaction().commit();
            manager.close();
        }
    }

    @Override
    public void deleteUser(User user) {
        if (!Objects.isNull(user)) {
            manager = JpaFactory.createEntityManager();
            userRepository = new UserRepository(manager);
            manager.getTransaction().begin();
            userRepository.delete(user);
            manager.getTransaction().commit();
            manager.close();
        }
    }
}
