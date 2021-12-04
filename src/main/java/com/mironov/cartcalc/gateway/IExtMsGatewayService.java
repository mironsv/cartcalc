package com.mironov.cartcalc.gateway;

import com.mironov.cartcalc.data.ProductCostEntity;
import com.mironov.cartcalc.dto.ProductDTO;

import java.util.List;

public interface IExtMsGatewayService {
    ProductCostEntity getProductCost(List<ProductDTO> products);
}
