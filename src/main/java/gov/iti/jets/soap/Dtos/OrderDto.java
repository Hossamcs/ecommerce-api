package gov.iti.jets.soap.Dtos;

import gov.iti.jets.repositories.entities.enums.Status;

import java.util.List;

public class OrderDto {
    private int id;
    private Status status;
    private List<ChooseProductDto> chooseProductDtos;

    public OrderDto(int id, Status status, List<ChooseProductDto> chooseProductDtos) {
        this.id = id;
        this.status = status;
        this.chooseProductDtos = chooseProductDtos;
    }

    public OrderDto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<ChooseProductDto> getChooseProductDtos() {
        return chooseProductDtos;
    }

    public void setChooseProductDtos(List<ChooseProductDto> chooseProductDtos) {
        this.chooseProductDtos = chooseProductDtos;
    }
}
