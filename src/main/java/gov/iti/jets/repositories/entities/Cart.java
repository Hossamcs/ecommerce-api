package gov.iti.jets.repositories.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Cart {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany(mappedBy = "cart" , cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    Set<CartLineItem> lineItems;

    @OneToOne
    private User owner;

    public Cart() {
       this.lineItems = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public Set<CartLineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems( Set<CartLineItem> lineItems ) {
        this.lineItems = lineItems;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner( User owner ) {
        this.owner = owner;
    }

    public void addItemToCart( CartLineItem item){
        this.lineItems.add( item );
        item.setCart( this );
    }

    public void removeItemFromCart(int itemId){
        lineItems.removeIf( (item) -> item.getId() == itemId );
    }
}
