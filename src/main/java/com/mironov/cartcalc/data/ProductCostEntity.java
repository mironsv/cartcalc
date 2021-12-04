package com.mironov.cartcalc.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProductCostEntity {
    List<ProductCost> productCostList;
}
