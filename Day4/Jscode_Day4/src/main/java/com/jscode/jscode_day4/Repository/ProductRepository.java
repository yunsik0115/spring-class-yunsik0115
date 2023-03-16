package com.jscode.jscode_day4.Repository;

import com.jscode.jscode_day4.Entity.Product;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import javax.print.attribute.HashPrintJobAttributeSet;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    private static final Map<Integer, Product> store = new HashMap<>();
    Random rand = new Random();

    public Product saveProduct(Product product){
        product.setId(rand.nextInt());
        store.put(product.getId(), product);

        return product;
    }

    public Optional<Product> findByName(String name){
        return store.values().stream().filter(product -> product.getName().equals(name))
            .findFirst();
    }

    public Optional<Product> findById(int id){
        return Optional.ofNullable(store.get(id));
    }

    public List<Product> findAll(){
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }


}
