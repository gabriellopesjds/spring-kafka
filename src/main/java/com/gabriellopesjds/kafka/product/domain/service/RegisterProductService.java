package com.gabriellopesjds.kafka.product.domain.service;

import com.gabriellopesjds.kafka.product.domain.model.Product;
import com.gabriellopesjds.kafka.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RegisterProductService {

    private final AsynchronousProcessingForSendMessageProduct messageSender;
    private final ProductRepository productRepository;

    public Product save(Product product){
        Product productSaved = productRepository.save(product);
        messageSender.sendMessage(productSaved);
        return  productSaved;
    }

}
