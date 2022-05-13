package gov.iti.jets.soap.controllers;

import gov.iti.jets.repositories.entities.Product;
import gov.iti.jets.services.Impl.ProductServiceImpl;
import gov.iti.jets.services.ProductService;
import gov.iti.jets.soap.Dtos.ProductDto;
import gov.iti.jets.soap.Util.SoapException;
import gov.iti.jets.soap.mapper.SoapMapper;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public class ProductsController {
    private final ProductService productService = new ProductServiceImpl();

    @WebMethod
    public ProductDto getProductById(int productId) throws SoapException {
        try {
            Product product = productService.getProductById(productId);
            return SoapMapper.mapProductToDto(product);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SoapException("no such product", e);
        }
    }
    @WebMethod
    public ProductDto deleteProductById(int productId) throws SoapException {
        try {
            Product product = productService.getProductById(productId);
            productService.deleteProduct(productId);
            return SoapMapper.mapProductToDto(product);
        } catch (Exception e) {
            throw new SoapException("fail to delete product", e);
        }
    }

    @WebMethod
    public ProductDto addNewProduct(ProductDto productDto) throws SoapException {
        try {
            Product product = new Product(productDto.getName(), productDto.getDescription(), productDto.getPrice());
            productService.addNewProduct(product);
            return SoapMapper.mapProductToDto(product);
        } catch (Exception e) {
            throw new SoapException("fail to add product", e);
        }
    }
}
