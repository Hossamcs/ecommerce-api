package gov.iti.jets.rest.Dto;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductCategories{
    private int id;
    private String description;
    private String name;

    public ProductCategories(){

    }

    public ProductCategories(int id, String description, String name ) {
        this.id = id;
        this.description = description;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "CategoryOfProduct{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
