package com.tmStore.common.dto.request;

import com.tmStore.common.enums.PRODUCT_CATEGORY;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {

    private String name;
    private String description;
    private BigDecimal price;
    private Long quantity;
    private PRODUCT_CATEGORY category;
}