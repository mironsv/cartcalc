package com.mironov.cartcalc.dto;

import com.mironov.cartcalc.data.ProductCost;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CalculatedCartDTO {

    private List<ProductCost> productCostList;
    private Float sum;
}
