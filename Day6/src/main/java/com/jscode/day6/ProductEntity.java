package com.jscode.day6;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;

@Table
@Entity
@Getter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Long price;

    public ProductEntity() {

    }

    public ProductEntity(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    public ProductDTO toProductDTO(){

        return new ProductDTO(this.name, this.price);

    }
}
