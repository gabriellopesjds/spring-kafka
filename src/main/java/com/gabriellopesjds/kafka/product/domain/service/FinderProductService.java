package com.gabriellopesjds.kafka.product.domain.service;

import com.gabriellopesjds.kafka.product.domain.model.Product;
import com.gabriellopesjds.kafka.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class FinderProductService {
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findByCode(String code) {
        return productRepository.findById(code)
            .orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }

    public List<Product> findByRangeSale(BigDecimal saleMin, BigDecimal saleMax) {
        return productRepository.findByRangeSale(saleMin, saleMax);
    }

}
