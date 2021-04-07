package com.gabriellopesjds.kafka.product.domain.service;

import com.gabriellopesjds.kafka.product.domain.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RegisterProductService {

    private final AsynchronousProcessingForSendMessageProduct messageSender;

    public Product save(Product product){
        product.setId(UUID.randomUUID());
        messageSender.sendMessage(product);
        return  product;
    }

}
