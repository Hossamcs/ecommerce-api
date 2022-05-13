package gov.iti.jets.rest.Dto;

import gov.iti.jets.repositories.entities.enums.Status;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;


@XmlRootElement
public class OrderDto {
    private int id;
    private Status status;
    private List<ChooseProductDto> chooseProductDtos;

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
