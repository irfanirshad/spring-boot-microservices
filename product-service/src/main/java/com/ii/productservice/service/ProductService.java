package com.ii.productservice.service;

import com.ii.productservice.dto.ProductRequest;
import com.ii.productservice.dto.ProductResponse;
import com.ii.productservice.model.Product;
import com.ii.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //if you remove then A will complain about needing a constructor
@Slf4j //logging
public class ProductService {

    private final ProductRepository productRepository ;

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId()) ;

    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList() ;
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

}

/*
After doing createProduct() we have to save it into our db
for that we need to access productRepository, so we'll inject productRepository into ProductService class
 */

