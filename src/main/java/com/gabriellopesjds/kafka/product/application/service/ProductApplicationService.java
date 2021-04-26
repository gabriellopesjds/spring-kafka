package com.gabriellopesjds.kafka.product.application.service;

import com.gabriellopesjds.kafka.product.domain.dto.request.ProductRequestDTO;
import com.gabriellopesjds.kafka.product.domain.dto.response.ProductResponseDTO;
import com.gabriellopesjds.kafka.product.domain.model.Product;
import com.gabriellopesjds.kafka.product.domain.service.FinderProductService;
import com.gabriellopesjds.kafka.product.domain.service.RegisterProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductApplicationService {

    private final RegisterProductService registerProductService;
    private final FinderProductService finderProductService;
    private final ProductFactory productFactory;

    public ProductResponseDTO save(ProductRequestDTO requestDTO){
        Product product = registerProductService.save(productFactory.createFrom(requestDTO));
        return productFactory.buildResponse(product);
    }

    public List<ProductResponseDTO> findAll() {
        List<Product> productList = finderProductService.findAll();
        return productFactory.buildResponse(productList);
    }

    public ProductResponseDTO findByCode(String code) {
        Product product = finderProductService.findByCode(code);
        return productFactory.buildResponse(product);
    }

    public List<ProductResponseDTO> findByRangeSale(BigDecimal saleMin, BigDecimal saleMax) {
        List<Product> productList = finderProductService.findByRangeSale(saleMin, saleMax);
        return productFactory.buildResponse(productList);
    }

}
