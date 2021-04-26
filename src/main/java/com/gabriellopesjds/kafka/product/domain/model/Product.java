package com.gabriellopesjds.kafka.product.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Getter
@Setter
@Document(collection = "product")
public class Product {

    @Id
    private String code;
    private String name;
    private BigDecimal saleValue;

}
