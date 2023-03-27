package com.jscode.day6;

import java.io.Serializable;
import lombok.Getter;

@Getter
public class ProductDTO implements Serializable {

    private String name;
    private long price;

    public ProductDTO(String name, long price) {
        this.name = name;
        this.price = price;
    }

    public static ProductDTO from(ProductEntity entity){
        return new ProductDTO(entity.getName(), entity.getPrice());
    }

    public ProductEntity toProductEntity(){
        return new ProductEntity(name, price);
    }

}
