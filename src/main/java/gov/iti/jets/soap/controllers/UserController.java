package gov.iti.jets.soap.controllers;

import gov.iti.jets.repositories.entities.Order;
import gov.iti.jets.repositories.entities.User;
import gov.iti.jets.services.Impl.OrderServiceImpl;
import gov.iti.jets.services.Impl.UserServiceImpl;
import gov.iti.jets.services.OrderService;
import gov.iti.jets.services.UserService;
import gov.iti.jets.soap.Dtos.OrderDto;
import gov.iti.jets.soap.Dtos.UserDto;
import gov.iti.jets.soap.Util.SoapException;
import gov.iti.jets.soap.mapper.SoapMapper;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.xml.soap.SOAPException;

import java.util.List;

@WebService
public class UserController {
    private final UserService userService = new UserServiceImpl();
    private final OrderService orderService = new OrderServiceImpl();

    @WebMethod
    public List<UserDto> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return SoapMapper.mapUserToDto(users);
    }

    @WebMethod
    public UserDto getUserById(int id) throws SOAPException {
        try {
            User existUser = userService.getUserById(id);
            return new UserDto(existUser);
        } catch (Exception e) {
            throw new SOAPException("NO Such User", e);
        }
    }

    @WebMethod
    public void addNewUser(UserDto userDto) throws SoapException {
        try {
            User user = new User(userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(), userDto.getRole());
            userService.addNewUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SoapException("Fail to add User", e);
        }
    }

    @WebMethod
    public UserDto deleteUser(int userId) throws SoapException {
        try {
            User user = userService.getUserById(userId);
            userService.deleteUser(user);
            return new UserDto(user);
        } catch (Exception e) {
            throw new SoapException("fail to Delet User", e);
        }
    }

    @WebMethod
    public String placeOrder(int userId) throws SoapException {
        try {
            User existUser = userService.getUserById(userId);
            orderService.addNewOrder(existUser);
            return "success to add Order";
        } catch (Exception e) {
            throw new SoapException("fail to add order", e);
        }
    }
}
