package com.gabriellopesjds.kafka.product.domain.service;

import com.gabriellopesjds.kafka.config.properties.AbstractQueueProperties;
import com.gabriellopesjds.kafka.config.properties.ProductQueueProperties;
import com.gabriellopesjds.kafka.product.domain.dto.response.ProductResponseDTO;
import com.gabriellopesjds.kafka.product.domain.model.Product;
import com.gabriellopesjds.kafka.utils.AsynchronousProcessingForSendMessage;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AsynchronousProcessingForSendMessageProduct extends AsynchronousProcessingForSendMessage<Product> {

    private final ProductQueueProperties productQueueProperties;

    @Override
    public AbstractQueueProperties getQueue() {
        return productQueueProperties;
    }

    @Override
    public Object buildMessage(Product messageObject) {
        return ProductResponseDTO.builder()
            .code(messageObject.getCode())
            .name(messageObject.getName())
            .saleValue(messageObject.getSaleValue())
            .build();
    }

}
