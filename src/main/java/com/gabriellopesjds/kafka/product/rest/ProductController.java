package com.gabriellopesjds.kafka.product.rest;

import com.gabriellopesjds.kafka.product.application.service.ProductApplicationService;
import com.gabriellopesjds.kafka.product.domain.dto.request.ProductRequestDTO;
import com.gabriellopesjds.kafka.product.domain.dto.response.ProductResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

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
            .path("/{code}")
            .buildAndExpand(responseDTO.getCode())
            .toUri();

        return ResponseEntity.created(uri).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> findAll(){
        List<ProductResponseDTO> responseDTOList = productApplicationService.findAll();
        return responseDTOList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(responseDTOList);
    }

    @GetMapping("/{code}")
    public ResponseEntity<ProductResponseDTO> findByCode(@PathVariable String code){
        ProductResponseDTO productResponseDTO = productApplicationService.findByCode(code);
        return ResponseEntity.ok(productResponseDTO);
    }

    @GetMapping("/range")
    public ResponseEntity<List<ProductResponseDTO>> findByRangeSale(@RequestParam BigDecimal saleMin, @RequestParam BigDecimal saleMax){
        List<ProductResponseDTO> responseDTOList = productApplicationService.findByRangeSale(saleMin, saleMax);
        return responseDTOList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(responseDTOList);
    }
}
