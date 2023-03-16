package com.jscode.jscode_day4.Service;

import com.jscode.jscode_day4.Entity.Product;
import com.jscode.jscode_day4.Entity.ProductDTO;
import com.jscode.jscode_day4.Repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.swing.text.html.Option;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(ProductDTO productDto){
        Product product = new Product(productDto.getName(), productDto.getPrice());
        ifSameNameOfProductExistException(product);
        return productRepository.saveProduct(product);
    }



    public List<Product> getAllProducts(String monetaryUnit){

        List<Product> allProductList = productRepository.findAll();

        if(monetaryUnit.equals("dollar")){
            List<Product> updatedList = allProductList.stream()
                .map(p -> new Product(p.getId() ,p.getName(), p.getPrice()/1200.))
                .collect(Collectors.toList());
            return updatedList;
        }

        return allProductList;
    }

    public Product findById(int productId, String monetaryUnit){
        Product product = productRepository.findById(productId).get();
        if(monetaryUnit.equals("dollar")){
            return new Product(product.getId() ,product.getName(), product.getPrice()/1200.);
        }
        return product;
    }

    public Product findByName(String productName, String monetaryUnit){

        ifProductNameNoMatchesException(productName);
        Product product = productRepository.findByName(productName).get();
        if(monetaryUnit.equals("dollar")){
            return new Product(product.getId() ,product.getName(), product.getPrice()/1200.);
        }
        return product;
    }

    private void ifProductNameNoMatchesException(String productName) {
        if(productRepository.findByName(productName).isEmpty()){
            throw new IllegalStateException("해당 상품이 존재하지 않습니다");
        }
    }

    private void ifSameNameOfProductExistException(Product product) {
        if(productRepository.findByName(product.getName()).isPresent()){
            throw new IllegalArgumentException("동일한 상품이 존재합니다");
        }
    }




}
