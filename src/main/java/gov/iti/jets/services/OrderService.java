package gov.iti.jets.services;

import gov.iti.jets.repositories.entities.Order;
import gov.iti.jets.repositories.entities.User;

public interface OrderService {
    public Order getOrderById(int OrderId);
    public void addNewOrder(User user);
    public void UpdateOrder(Order order);
}
