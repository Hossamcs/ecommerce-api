package gov.iti.jets.soap.Dtos;

import gov.iti.jets.repositories.entities.OrderLineItem;

public class ChooseProductDto {
    private int id;
    private int productId;
    private int quantity;

    public ChooseProductDto() {

    }

    public ChooseProductDto(OrderLineItem orderLineItem ) {
        this.id = orderLineItem.getId();
        this.productId = orderLineItem.getProduct().getId();
        this.quantity = orderLineItem.getQuantity();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
