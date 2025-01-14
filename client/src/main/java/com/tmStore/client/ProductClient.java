package com.tmStore.client;

import com.tmStore.common.dto.request.ProductRequest;
import com.tmStore.common.dto.response.ApiResponse;
import com.tmStore.common.dto.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient("product")
public interface ProductClient {

    @GetMapping
    ApiResponse<List<ProductResponse>> getAllProducts();

    @GetMapping("/{id}")
    ApiResponse<ProductResponse> getProductById(@PathVariable("id") Long id);

    @PostMapping
    ApiResponse<ProductResponse> addProduct(@RequestBody ProductRequest productRequest);

    @PutMapping("/{id}")
    ApiResponse<ProductResponse> updateProduct(
            @PathVariable("id") Long id,
            @RequestBody ProductRequest productRequest);

    @DeleteMapping("/{id}")
    ApiResponse<Void> deleteProduct(@PathVariable("id") Long id);
}
