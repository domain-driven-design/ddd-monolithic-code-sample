package com.dmall.productservice.apis.assembler;

import com.dmall.productservice.apis.dto.ProductCreationRequest;
import com.dmall.productservice.apis.dto.ProductResponse;
import com.dmall.productservice.application.ProductFactory;
import com.dmall.productservice.domain.product.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductAssembler {

    protected static final ModelMapper mapper = new ModelMapper();

    @Autowired
    private ProductFactory productFactory;
    private final boolean isOnSale = false;

    public Product toDomainObject(ProductCreationRequest creationRequest) {
        return productFactory.create(creationRequest.getName(),
                creationRequest.getDescription(), creationRequest.getPrice(), isOnSale);
    }

    public ProductCreationRequest toDto(Product product) {
        return mapper.map(product, ProductCreationRequest.class);
    }

    public ProductResponse toProductResponse(Product product) {
        if (product != null) {
            return mapper.map(product, ProductResponse.class);
        } else {
            return null;
        }
    }

    public List<ProductResponse> toProductResponseList(List<Product> products) {
        return products.stream()
                .map(c -> mapper.map(c, ProductResponse.class))
                .collect(Collectors.toList());
    }
}
