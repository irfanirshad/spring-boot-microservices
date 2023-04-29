package com.ii.productservice.controller;

import com.ii.productservice.dto.ProductRequest;
import com.ii.productservice.dto.ProductResponse;
import com.ii.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
            //going to act as a DTO
        /* to actually create the product,
            we have to do the processing of the biz logic in
            the service layer, not in the controller layer
         */

        productService.createProduct(productRequest) ;
        //endpoint to create products
        //now we need another endpoint to retrieve all the products
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts() ;
    }
}
