package gov.iti.jets.repositories.entities;

import gov.iti.jets.repositories.entities.enums.Status;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "orders" )
public class Order {
    @Id
    @GeneratedValue
    private int id;

    @OneToMany( mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderLineItem> lineItems = new ArrayList<>();

    @ManyToOne
    private User maker;

    @Enumerated( EnumType.STRING )
    private Status status;

    public Order() {
    }

     public Order( Cart cart ) {
        cart.getLineItems().forEach( item -> {
             addLineItemToOrder( new OrderLineItem(item.getProduct(), item.getQuantity()) );
         } );

         this.maker = cart.getOwner();
         this.status = Status.PENDING;
     }

    public User getMaker() {
        return maker;
    }

    public int getId() {
        return id;
    }

    public List<OrderLineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems( List<OrderLineItem> lineItems ) {
        this.lineItems = lineItems;
    }

    public void setMaker( User maker ) {
        this.maker = maker;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus( Status status ) {
        this.status = status;
    }

    public void addLineItemToOrder( OrderLineItem lineItem){
        this.lineItems.add( lineItem );
        lineItem.setOrder( this );
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", lineItems=" + lineItems +
                ", maker=" + maker.getId() +
                ", status=" + status +
                '}';
    }
}
