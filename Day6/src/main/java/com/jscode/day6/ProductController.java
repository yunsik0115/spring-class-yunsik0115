package com.jscode.day6;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/api/product")
    public ProductEntity saveProduct(@RequestBody ProductEntity product){
        return productService.save(product);
    }

    @GetMapping("/api/products")
    public List<ProductEntity> getAllProducts(){
        return productService.findAll();
    }

    @GetMapping("/api/product")
    public List<ProductEntity> getProduct
        (
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "price", required = false) Long price){

        if(name != null && price != null){
            return productService.findByNameAndPrice(name, price);
        }

        if(name != null){
            return productService.findByName(name);
        }

        return productService.findByPrice(price);


    }

    @GetMapping("/api/product/getbyid")
    public ProductEntity getProductById(
        @RequestParam(value = "id", required = true) long id
    ){
        return productService.findById(id);
    }

    @GetMapping("/api/products/OrderByPrice")
    public List<ProductEntity> productOrderByPrice(){
        return productService.productOrderByPricePrintingName();
    }

    @GetMapping("/api/products/mostExpensiveOne")
    public List<ProductEntity> mostExpensiveOne(){
        return productService.productWhichIsMostExpensive();
    }

    @GetMapping("/api/products/whichHasCharacter")
    public List<ProductEntity> whichHasCharacter(){
        return productService.whichHasCharacter();
    }

    @GetMapping("/api/products/whichHasNotStringMonitor")
    public List<ProductEntity> whichHasStringMonitor(){
        return productService.HasMonitor();
    }

    @GetMapping("/api/products/avgPrice")
    public long avgPrice(){
        return productService.productAvgPrice();
    }


}
