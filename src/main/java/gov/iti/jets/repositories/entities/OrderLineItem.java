package gov.iti.jets.repositories.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class OrderLineItem {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Product product;

    private int quantity;

    @ManyToOne
    @JoinColumn( name = "order_id" )
    private Order order;

    public Order getOrder() {
        return order;
    }

    public OrderLineItem() {
    }

    public OrderLineItem( Product product, int quantity ) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getId() {
        return id;
    }

    public void setProduct( Product product ) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity( int quantity ) {
        this.quantity = quantity;
    }

    public void setOrder( Order order ) {
        this.order = order;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        CartLineItem lineItem = (CartLineItem) o;

        return product.getId() == product.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(product.getId());
    }
}