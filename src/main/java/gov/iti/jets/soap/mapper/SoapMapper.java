package gov.iti.jets.soap.mapper;

import gov.iti.jets.repositories.entities.Category;
import gov.iti.jets.repositories.entities.Product;
import gov.iti.jets.repositories.entities.User;
import gov.iti.jets.soap.Dtos.CategoryDto;
import gov.iti.jets.soap.Dtos.OrderDto;
import gov.iti.jets.soap.Dtos.ProductDto;
import gov.iti.jets.soap.Dtos.UserDto;

import java.util.List;
import java.util.stream.Collectors;

public class SoapMapper {

    public static List<UserDto> mapUserToDto(List<User> userList ){
    return  userList.stream().map(UserDto::new ).collect( Collectors.toList());
    }


    public static CategoryDto mapCategoryTDto(Category category ){
        return new CategoryDto( category.getId(), category.getName() );
    }
    public static ProductDto mapProductToDto(Product product ){
        ProductDto productDto;
        productDto= new ProductDto( product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getCategories()
                .stream()
                .map(SoapMapper::mapCategoryTDto)
                .collect( Collectors.toList()) );
        return productDto;
    }

}
