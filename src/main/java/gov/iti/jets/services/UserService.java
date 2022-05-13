package gov.iti.jets.services;

import gov.iti.jets.repositories.entities.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User getUserById(int userId);
    public void addNewUser(User user);
    public void updateUSer(User user);
    public void deleteUser(User user);

}
