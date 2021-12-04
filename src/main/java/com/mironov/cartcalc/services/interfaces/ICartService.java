package com.mironov.cartcalc.services.interfaces;

import com.mironov.cartcalc.dto.CalculatedCartDTO;
import com.mironov.cartcalc.dto.CartDTO;

public interface ICartService {
    CalculatedCartDTO calculateCart(CartDTO cartDTO);
}
