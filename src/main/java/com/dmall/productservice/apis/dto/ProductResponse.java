package com.dmall.productservice.apis.dto;

import lombok.*;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ProductResponse {
    @ApiModelProperty(example = "1")
    private Long id;
    @ApiModelProperty(example = "Computer")
    private String name;
    @ApiModelProperty(example = "32G Memory and 1T HardDisk")
    private String description;
    @ApiModelProperty(example = "1000.00")
    private BigDecimal price;
}
