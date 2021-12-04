package com.mironov.cartcalc.controller;

import com.mironov.cartcalc.dto.CalculatedCartDTO;
import com.mironov.cartcalc.dto.CartDTO;
import com.mironov.cartcalc.services.implementations.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    /**
     * calculate customer's cart
     *
     * @param cartDTO cart
     * @return calculated cart
     */
    @GetMapping("/calculate")
    @PreAuthorize("hasRole('USER')")
    public CalculatedCartDTO calculateCart(@RequestBody CartDTO cartDTO) {
        return cartService.calculateCart(cartDTO);
    }

}
