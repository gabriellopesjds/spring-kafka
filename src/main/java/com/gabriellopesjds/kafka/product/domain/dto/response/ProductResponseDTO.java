package com.gabriellopesjds.kafka.product.domain.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class ProductResponseDTO {
    private UUID id;
    private String name;
}
