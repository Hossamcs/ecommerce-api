package gov.iti.jets.rest.Dto;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="product")
public class ResponseProductDto {
    private int id;
    private String name;
    private String description;
    private BigDecimal price;

    @XmlElementWrapper
    @XmlElement(name = "category")
    private List<CategoryDto> categories;

    public ResponseProductDto(int id, String name, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.categories = new ArrayList<>();
    }

    public ResponseProductDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<CategoryDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDto> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "ResponseProductDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", categories="  +
                '}';
    }
}
