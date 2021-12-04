package com.mironov.cartcalc.services;

import com.mironov.cartcalc.services.implementations.CartService;
import com.mironov.cartcalc.services.interfaces.ICartService;
import com.mironov.cartcalc.data.ProductCost;
import com.mironov.cartcalc.data.ProductCostEntity;
import com.mironov.cartcalc.dto.CalculatedCartDTO;
import com.mironov.cartcalc.dto.CartDTO;
import com.mironov.cartcalc.dto.ProductDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CartServiceTest {

    private static final CalculatedCartDTO CALCULATED_CART =
            new CalculatedCartDTO(new ArrayList<>(), 1.0f);
    private static final String URL = "https://localhost:9001/calc";

    ICartService cartService = new CartService();

    @InjectMocks
    private RestTemplate restTemplate;

    @BeforeEach
    void setMockOutput() {
        List<ProductCost> productCostList = new ArrayList<>();
        productCostList.add(new ProductCost(1, 1.0f));
        when(restTemplate.postForObject(URL, any(), ProductCostEntity.class))
                .thenReturn(new ProductCostEntity(productCostList));
    }

    @DisplayName("Mock external MS, get product price list")
    @Test
    void testCalculateCart() {
        List<ProductDTO> products = new ArrayList<>();
        CartDTO cartDTO = new CartDTO(products, "paymentType", 123);
        assertEquals(CALCULATED_CART, cartService.calculateCart(cartDTO));
    }

}
