package com.gabriellopesjds.kafka.product.domain.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class ProductResponseDTO {
    private String code;
    private String name;
    private BigDecimal saleValue;
}
