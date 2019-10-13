package com.dmall.productservice.apis.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Getter
@Setter
@ApiModel
public class ProductCreationRequest {

    @ApiModelProperty(example = "Computer")
    private String name;

    @ApiModelProperty(example = "32G Memory and 1T HardDisk")
    private String description;

    @ApiModelProperty(example = "1000.00")
    private BigDecimal price;
}
