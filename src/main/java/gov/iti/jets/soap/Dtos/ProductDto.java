package gov.iti.jets.soap.Dtos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductDto {
    private int id;
    private String name;
    private String description;
    private BigDecimal price;
    private List<CategoryDto> categories;

    public ProductDto(int id, String name, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.categories=new ArrayList<>();
    }

    public ProductDto(int id, String name, String description, BigDecimal price, List<CategoryDto> collect) {
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
}
