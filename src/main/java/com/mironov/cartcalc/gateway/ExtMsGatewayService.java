package com.mironov.cartcalc.gateway;

import com.mironov.cartcalc.data.ProductCostEntity;
import com.mironov.cartcalc.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ExtMsGatewayService implements IExtMsGatewayService {
    @Autowired
    private RestTemplate restTemplate;

    private final String url;

    public ExtMsGatewayService(String url) {
        this.url = url;
    }

    @Override
    public ProductCostEntity getProductCost(List<ProductDTO> products) {
        return restTemplate.postForObject(url, products, ProductCostEntity.class);
    }
}
