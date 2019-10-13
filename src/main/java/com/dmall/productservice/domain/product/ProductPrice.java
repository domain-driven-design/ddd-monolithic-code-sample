
package com.dmall.productservice.domain.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Getter
@Setter
public class ProductPrice {

    private String currency;

    private BigDecimal value;

    static public ProductPrice of(String currency, BigDecimal value) {
        return new ProductPrice(currency, value);
    }
}

