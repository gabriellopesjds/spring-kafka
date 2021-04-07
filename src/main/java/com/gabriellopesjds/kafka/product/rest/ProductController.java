package com.gabriellopesjds.kafka.product.rest;

import com.gabriellopesjds.kafka.product.application.service.ProductApplicationService;
import com.gabriellopesjds.kafka.product.domain.dto.request.ProductRequestDTO;
import com.gabriellopesjds.kafka.product.domain.dto.response.ProductResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/products")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController {

    private final ProductApplicationService productApplicationService;

    @PostMapping
    public ResponseEntity<ProductResponseDTO> save(@RequestBody ProductRequestDTO requestDTO){
        ProductResponseDTO responseDTO = productApplicationService.save(requestDTO);
        URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(responseDTO.getId())
            .toUri();

        return ResponseEntity.created(uri).body(responseDTO);
    }
}
