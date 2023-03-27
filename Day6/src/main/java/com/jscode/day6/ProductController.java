package com.jscode.day6;

import java.util.ArrayList;
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
    public ProductDTO saveProduct(@RequestBody ProductDTO product){
        // return productService.save(product);
        ProductEntity productEntity = product.toProductEntity();
        productService.save(productEntity);
        return product;
    }

    @GetMapping("/api/products")
    public List<ProductDTO> getAllProducts(){
        // return productService.findAll();
        List<ProductEntity> retrievedProducts = productService.findAll();
        List<ProductDTO> productDTOList = getProductEntityListToDtoList(retrievedProducts);

        return productDTOList;
    }


    // Method Extraction for Retriving and Converting to DTO from ProductEntity List -> ProductDTO List
    private static List<ProductDTO> getProductEntityListToDtoList(List<ProductEntity> retrievedProducts) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (ProductEntity retrievedProduct : retrievedProducts) {
            productDTOList.add(retrievedProduct.toProductDTO());
        }
        return productDTOList;
    }

    @GetMapping("/api/product")
    public List<ProductDTO> getProduct
        (
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "price", required = false) Long price){

        List<ProductEntity> productEntityList;

        if(name != null && price != null){
            productEntityList = productService.findByNameAndPrice(name, price);
            return getProductEntityListToDtoList(productEntityList);
        }

        if(name != null){
            productEntityList = productService.findByName(name);
            return getProductEntityListToDtoList(productEntityList);
            //return productService.findByName(name);
        }

        productEntityList = productService.findByPrice(price);
        return getProductEntityListToDtoList(productEntityList);
        //return productService.findByPrice(price);


    }

    @GetMapping("/api/product/getbyid")
    public ProductDTO getProductById(
        @RequestParam(value = "id", required = true) long id
    ){
        ProductEntity productEntity = productService.findById(id);
        return productEntity.toProductDTO();
        //return productService.findById(id);
    }

    @GetMapping("/api/products/OrderByPrice")
    public List<ProductDTO> productOrderByPrice(){
        List<ProductEntity> productEntityList = productService.productOrderByPricePrintingName();
        return getProductEntityListToDtoList(productEntityList);
        //return productService.productOrderByPricePrintingName();
    }

    @GetMapping("/api/products/mostExpensiveOne")
    public List<ProductDTO> mostExpensiveOne(){
        //return productService.productWhichIsMostExpensive();
        List<ProductEntity> productEntityList = productService.productWhichIsMostExpensive();
        return getProductEntityListToDtoList(productEntityList);
    }

    @GetMapping("/api/products/whichHasCharacter")
    public List<ProductDTO> whichHasCharacter(){
        List<ProductEntity> productEntityList = productService.whichHasCharacter();
        return getProductEntityListToDtoList(productEntityList);
        //return productService.whichHasCharacter();
    }

    @GetMapping("/api/products/whichHasNotStringMonitor")
    public List<ProductDTO> whichHasStringMonitor(){
        //return productService.HasMonitor();
        List<ProductEntity> productEntityList = productService.HasMonitor();
        return getProductEntityListToDtoList(productEntityList);
    }


    // 밑에 이건 DTO 사용 필요....?
    @GetMapping("/api/products/avgPrice")
    public long avgPrice(){
        return productService.productAvgPrice();
    }


}
