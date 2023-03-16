package com.jscode.jscode_day4.Controller;

import com.jscode.jscode_day4.Entity.Product;
import com.jscode.jscode_day4.Entity.ProductDTO;
import com.jscode.jscode_day4.Service.ProductService;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 상품 정보 등록 POST
    @PostMapping("/api/product")
    public void registerProduct(@RequestBody ProductDTO productDto){
        productService.saveProduct(productDto);
    }

    @GetMapping("/api/product/byName") // Rest하게 설계하고 싶었는데, 저거 안달면 Exception handler가 인식을 못하는 듯 함.
    public Product getProductInfoByName(
        @RequestParam(value = "name") String productName,
        @RequestParam(value = "monetaryUnit", defaultValue = "won")
        String monetaryUnit){
        Product product = productService.findByName(productName, monetaryUnit);
        return product;
    }

    // 상품 정보 GET
    @GetMapping("/api/products")
    public List<Product> getAllProductInfo(@RequestParam(value = "monetaryUnit", required = false, defaultValue = "won") String monetaryUnit){
        return productService.getAllProducts(monetaryUnit);
    }

    @GetMapping("/api/product/{productId}")
    public Product getProductInfoById(@PathVariable int productId, @RequestParam("monetaryUnit") String monetaryUnit){
        Product product = productService.findById(productId, monetaryUnit);
        return product;

    }








}
