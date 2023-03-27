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

    /*
    * 전체 상품을 조회하는데, name이 모니터인 상품은 무시

    가장 가격이 비싼 상품 조회하기

    이름에 “컴”을 포함하는 상품 조회하기

    가장 가격이 저렴한 상품의 ‘이름만’ 조회하기

    상품 가격의 평균 구하기*/

    // Select * FROM ProductEntity WHERE NOT name="모니터"
    // SELECT * FROM ProductEntity ORDER BY ProductEntity.price DESC Limit 0 1
    // SELECT * FROM ProductEntity WHERE name="*컴*"
    // SELECT ProductEntity.name FROM ProductEntity ORDER BY ProductEntity.Price DESC
    // SELECT AVG(ProductEntity.price) FROM ProductEntity

    @Query(value = "select productEntity "+ "from ProductEntity productEntity "+
    "WHERE NOT productEntity.name = '모니터'")
    List<ProductEntity> findProductContainsStringMonitor();


    @Query(value = "select * from product_entity ORDER BY price desc limit 1", nativeQuery = true)
    List<ProductEntity> findMostExpensiveProduct();

    @Query(value = "select * from product_entity ORDER BY price ASC limit 1", nativeQuery = true)
    List<ProductEntity> findMostCheapestProduct();

    @Query(value = "select productEntity " + "from ProductEntity productEntity "
    + "WHERE productEntity.name LIKE '%컴%' ")
    List<ProductEntity> findCharacterContains();

    @Query(value = "select productEntity.name " + "from ProductEntity productEntity "
        + "order by productEntity.price desc")
    List<ProductEntity> findByPriceOrderPrintingName();

    @Query(value = "select avg(productEntity.price) " + "from ProductEntity productEntity")
    long productAvgPrice();



}
