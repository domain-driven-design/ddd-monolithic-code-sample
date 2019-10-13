
package com.dmall.productservice.domain.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Getter
@Setter
public class ProductAttribute {
    private String id;
    private String color;

    private String size;
}

