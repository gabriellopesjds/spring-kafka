package com.gabriellopesjds.kafka.product.application.service;

import com.gabriellopesjds.kafka.product.domain.dto.request.ProductRequestDTO;
import com.gabriellopesjds.kafka.product.domain.dto.response.ProductResponseDTO;
import com.gabriellopesjds.kafka.product.domain.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductFactory {

    public Product createFrom(ProductRequestDTO requestDTO) {
        Product product = new Product();
        product.setName(requestDTO.getName());
        product.setSaleValue(requestDTO.getSaleValue());
        return product;
    }

    public ProductResponseDTO buildResponse(Product product) {
        return ProductResponseDTO.builder()
            .code(product.getCode())
            .name(product.getName())
            .saleValue(product.getSaleValue())
            .build();
    }

    public List<ProductResponseDTO> buildResponse(List<Product> productList) {
        return productList
            .stream()
            .map(this::buildResponse)
            .collect(Collectors.toList());
    }

}
