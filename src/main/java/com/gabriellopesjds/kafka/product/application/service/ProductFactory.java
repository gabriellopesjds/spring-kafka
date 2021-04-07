package com.gabriellopesjds.kafka.product.application.service;

import com.gabriellopesjds.kafka.product.domain.dto.request.ProductRequestDTO;
import com.gabriellopesjds.kafka.product.domain.dto.response.ProductResponseDTO;
import com.gabriellopesjds.kafka.product.domain.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductFactory {

    public Product createFrom(ProductRequestDTO requestDTO) {
        Product product = new Product();
        product.setName(requestDTO.getName());
        return product;
    }

    public ProductResponseDTO buildResponse(Product product) {
        return ProductResponseDTO.builder()
            .id(product.getId())
            .name(product.getName())
            .build();
    }

}
