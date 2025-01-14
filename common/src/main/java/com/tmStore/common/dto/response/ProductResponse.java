package com.tmStore.common.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tmStore.product.enums.PRODUCT_CATEGORY;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Long quantity;
    private PRODUCT_CATEGORY category;
}
