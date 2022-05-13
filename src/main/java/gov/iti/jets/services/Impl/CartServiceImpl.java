package gov.iti.jets.services.Impl;

import gov.iti.jets.repositories.entities.CartLineItem;
import gov.iti.jets.repositories.entities.User;
import gov.iti.jets.services.CartService;
import gov.iti.jets.services.UserService;

public class CartServiceImpl implements CartService {
    private UserService userService = new UserServiceImpl();

    @Override
    public void addProductToCart(int userId, CartLineItem item) {
        User user = userService.getUserById(userId);
        user.getCart().addItemToCart(item);
        userService.updateUSer(user);
    }

    @Override
    public void deleteProductFromCart(int userId, int productId) {
        User user = userService.getUserById(userId);
        user.getCart().removeItemFromCart(productId);
        userService.updateUSer(user);
    }

    @Override
    public void emptyCart(int userId) {
        User user = userService.getUserById(userId);
        user.getCart().getLineItems().clear();
        userService.updateUSer(user);
    }
}
