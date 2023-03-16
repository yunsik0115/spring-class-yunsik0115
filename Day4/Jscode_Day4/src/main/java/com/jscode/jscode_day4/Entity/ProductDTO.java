package com.jscode.jscode_day4.Entity;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProductDTO {

    private String name;
    private int price;

    public ProductDTO(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
