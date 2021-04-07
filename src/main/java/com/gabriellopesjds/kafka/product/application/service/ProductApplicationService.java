package com.gabriellopesjds.kafka.product.application.service;

import com.gabriellopesjds.kafka.product.domain.dto.request.ProductRequestDTO;
import com.gabriellopesjds.kafka.product.domain.dto.response.ProductResponseDTO;
import com.gabriellopesjds.kafka.product.domain.model.Product;
import com.gabriellopesjds.kafka.product.domain.service.RegisterProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductApplicationService {

    private final RegisterProductService registerProductService;
    private final ProductFactory productFactory;

    public ProductResponseDTO save(ProductRequestDTO requestDTO){
        Product product = registerProductService.save(productFactory.createFrom(requestDTO));
        return productFactory.buildResponse(product);
    }


}
