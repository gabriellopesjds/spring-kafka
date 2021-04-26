package com.gabriellopesjds.kafka.product.repository;

import com.gabriellopesjds.kafka.product.domain.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    @Query("{ $and: [ { 'saleValue' : { $gte: ?0 } }, { 'saleValue' : { $lte: ?1 } } ] }")
    List<Product> findByRangeSale(BigDecimal minSale, BigDecimal maxSale);
}
