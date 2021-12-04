package com.mironov.cartcalc.services.implementations;

import com.mironov.cartcalc.data.ProductCost;
import com.mironov.cartcalc.data.ProductCostEntity;
import com.mironov.cartcalc.dto.CalculatedCartDTO;
import com.mironov.cartcalc.dto.CartDTO;
import com.mironov.cartcalc.dto.ProductDTO;
import com.mironov.cartcalc.exception.CostNotFoundException;
import com.mironov.cartcalc.gateway.IExtMsGatewayService;
import com.mironov.cartcalc.services.interfaces.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService {

    @Autowired
    IExtMsGatewayService extMsGatewayService;

    public CalculatedCartDTO calculateCart(CartDTO cartDTO) {
        ProductCostEntity productCostEntity = getProductCost(cartDTO.getProducts());
        if (productCostEntity == null || productCostEntity.getProductCostList() == null) {
            throw new CostNotFoundException();
        }
        Float sum = productCostEntity.getProductCostList().stream()
                .map(ProductCost::getCost)
                .reduce(0f, Float::sum);
        return new CalculatedCartDTO(productCostEntity.getProductCostList(), sum);
    }

    @Cacheable(cacheNames = "productCost")
    public ProductCostEntity getProductCost(List<ProductDTO> products) {
        return extMsGatewayService.getProductCost(products);
    }

}
