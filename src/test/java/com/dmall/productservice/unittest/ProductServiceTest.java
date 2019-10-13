package com.dmall.productservice.unittest;

import com.dmall.productservice.application.ProductService;
import com.dmall.productservice.domain.product.Product;
import com.dmall.productservice.domain.product.ProductPrice;
import com.dmall.productservice.infrastructure.repositories.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository repository;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldCallRepositoryToFindProductById() {
        Long productId = 100L;
        Product expected = new Product(productId, "iPhone", "newest iPhone",  ProductPrice.of("RMB",new BigDecimal(2000)));

        when(repository.findById(productId)).thenReturn(expected);

        productService.getProductsById(productId);
        verify(repository, atLeastOnce()).findById(productId);
    }

    @Test
    public void shouldGetAllProducts() {
        Product iphone = new Product(10L, "iPhone", "newest iPhone", ProductPrice.of("RMB",new BigDecimal(2000)));
        Product mac = new Product(11L, "Mac", "mac", ProductPrice.of("RMB",new BigDecimal(2000)));
        List<Product> list = new ArrayList<>(2);
        list.add(iphone);
        list.add(mac);

        when(repository.findAll()).thenReturn(list);

        List<Product> result = productService.getProducts();

        assertEquals(2, result.size());
        assertEquals(10L, result.get(0).getId().longValue());
        assertEquals(11L, result.get(1).getId().longValue());

    }
}
