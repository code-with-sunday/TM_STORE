package com.tmStore.product.controller;

import com.tmStore.common.dto.request.ProductRequest;
import com.tmStore.common.dto.response.ApiResponse;
import com.tmStore.common.dto.response.ProductResponse;
import com.tmStore.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product/")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ApiResponse<List<ProductResponse>> getAllProducts() {
        List<ProductResponse> products = productService.getAllProducts();
        return new ApiResponse<>(true, "200", "Products fetched successfully", products);
    }

    @GetMapping("/{id}")
    public ApiResponse<ProductResponse> getProductById(@PathVariable Long id) {
        ProductResponse product = productService.getProductById(id);
        return new ApiResponse<>(true, "200", "Product fetched successfully", product);
    }

    @PostMapping
    public ApiResponse<ProductResponse> addProduct(@RequestBody ProductRequest productRequest) {
        ProductResponse product = productService.addProduct(productRequest);
        return new ApiResponse<>(true, "201", "Product added successfully", product);
    }

    @PutMapping("/{id}")
    public ApiResponse<ProductResponse> updateProduct(
            @PathVariable Long id,
            @RequestBody ProductRequest productRequest) {
        ProductResponse updatedProduct = productService.updateProduct(id, productRequest);
        return new ApiResponse<>(true, "200", "Product updated successfully", updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ApiResponse<>(true, "204", "Product deleted successfully");
    }
}
