package com.gabriellopesjds.kafka.product.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Product {

    private UUID id;
    private String name;

}
