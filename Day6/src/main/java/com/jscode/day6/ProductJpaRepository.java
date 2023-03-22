package com.jscode.day6;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByName(String name);
    List<ProductEntity> findByPrice(Long price);

    @Query(value = "select productEntity "+ "from ProductEntity productEntity "+
    "where productEntity.name = :name AND productEntity.price = :price")
    List<ProductEntity> findByNameAndPrice(@Param("name") String name, @Param("price") Long price);

}
