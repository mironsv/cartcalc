package com.mironov.cartcalc.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductCost {
    private Integer id;
    private Float cost;
}
