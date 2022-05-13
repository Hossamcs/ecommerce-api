package gov.iti.jets.services;

import gov.iti.jets.repositories.entities.CartLineItem;

public interface CartService {
    public void addProductToCart(int UserId, CartLineItem item);
    public void deleteProductFromCart(int userId,int productId);
    public  void  emptyCart(int userId);

}
