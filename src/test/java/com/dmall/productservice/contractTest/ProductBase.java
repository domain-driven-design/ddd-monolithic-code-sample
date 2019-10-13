package com.dmall.productservice.contractTest;

import com.dmall.productservice.apis.ProductController;
import com.dmall.productservice.apis.assembler.ProductAssembler;
import com.dmall.productservice.apis.dto.ProductCreationRequest;
import com.dmall.productservice.apis.dto.ProductResponse;
import com.dmall.productservice.application.ProductService;
import com.dmall.productservice.domain.product.Product;
import com.dmall.productservice.domain.product.ProductPrice;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Ignore
@AutoConfigureMockMvc
public class ProductBase {
    @Autowired
    WebApplicationContext wac;

    @Before
    public void setUp() throws Exception {
        final ProductService productService = mock(ProductService.class);
        final ProductAssembler productAssembler = mock(ProductAssembler.class);

        Product product1 = new Product(10L, "Mac mini", "Mac mini computer",  ProductPrice.of("RMB",new BigDecimal(2000)));
        Product product2 = new Product(20L, "iPhone X", "iPhone 2018 new fashion",  ProductPrice.of("RMB",new BigDecimal(2000)));
        List<Product> products = Arrays.asList(product1, product2);
        ProductResponse response1 = new ProductResponse();
        response1.setId(10L);
        response1.setName("Mac mini");
        response1.setDescription("Mac mini computer");
        response1.setPrice(new BigDecimal(9888.00));

        ProductResponse response2 = new ProductResponse();
        response2.setId(20L);
        response2.setName("iPhone X");
        response2.setDescription("iPhone 2018 new fashion");
        response2.setPrice(new BigDecimal(8888.00));

        when(productService.getProducts()).thenReturn(products);
        when(productService.getProductsById(anyLong())).thenReturn(product1);
        when(productService.save(any(Product.class))).thenReturn(product1);


        when(productAssembler.toDomainObject(any(ProductCreationRequest.class))).thenReturn(product1);
        when(productAssembler.toProductResponse(any(Product.class))).thenReturn(response1);
        when(productAssembler.toProductResponseList(anyList())).thenReturn(Arrays.asList(response1, response2));

        RestAssuredMockMvc.standaloneSetup(new ProductController(productService, productAssembler));
    }
}

