package gov.iti.jets.rest.Mapper;

import gov.iti.jets.repositories.entities.Category;
import gov.iti.jets.repositories.entities.Product;
import gov.iti.jets.repositories.entities.User;
import gov.iti.jets.rest.Dto.CategoryDto;
import gov.iti.jets.rest.Dto.ResponseProductDto;
import gov.iti.jets.rest.Dto.UserDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class RestMapper {

    public static UserDto mapUserToDto(User user){
        UserDto userDto = new UserDto(user);
        return userDto;
    }
    public static List<CategoryDto> mapCategoryToDto(Set<Category> categories){

        List<CategoryDto> categoryDtos = new ArrayList<>();
        categories.forEach(category ->{
           CategoryDto mappedCategoryDto = new CategoryDto(category.getId(), category.getName());
            categoryDtos.add( mappedCategoryDto );
        });
        return categoryDtos;
    }

    public static ResponseProductDto mapProductToResponse(Product product){
        ResponseProductDto dto = new ResponseProductDto(product.getId(), product.getName(), product.getDescription(), product.getPrice());
        dto.setCategories( mapCategoryToDto(product.getCategories()));
        return dto;
    }

}
