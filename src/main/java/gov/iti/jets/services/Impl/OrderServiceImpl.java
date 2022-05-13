package gov.iti.jets.services.Impl;

import gov.iti.jets.repositories.OrderRepository;
import gov.iti.jets.repositories.entities.Order;
import gov.iti.jets.repositories.entities.User;
import gov.iti.jets.repositories.util.JpaFactory;
import gov.iti.jets.services.OrderService;
import gov.iti.jets.services.UserService;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.NotFoundException;

import java.util.Objects;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {
    private EntityManager manager;
    private OrderRepository repo;
    private  UserService userService=new UserServiceImpl() ;

    @Override
    public Order getOrderById(int OrderId) {
        manager = JpaFactory.createEntityManager();
        repo = new OrderRepository(manager);
        Optional<Order> order = repo.findOne(OrderId);
        manager.close();
        if (order.isPresent()) {
            return order.get();
        } else {
            throw new NotFoundException();
        }

    }

    @Override
    public void addNewOrder(User user) {
        if (!Objects.isNull(user)) {
            Order order = new Order(user.getCart());
            user.addOrderToUser(order);
            user.getCart().getLineItems().clear();
            userService.updateUSer(user);
        }
    }

    @Override
    public void UpdateOrder(Order order) {
        manager = JpaFactory.createEntityManager();
        repo = new OrderRepository(manager);
        manager.getTransaction().begin();
        repo.update(order);
        manager.getTransaction().commit();
        manager.close();
    }
}
