package com.gabriellopesjds.kafka.product.domain.dto.request;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ProductRequestDTO {
    private String name;
    private BigDecimal saleValue;
}
