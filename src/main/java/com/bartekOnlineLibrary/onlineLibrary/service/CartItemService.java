package com.bartekOnlineLibrary.onlineLibrary.service;

import com.bartekOnlineLibrary.onlineLibrary.model.CartItem;
import com.bartekOnlineLibrary.onlineLibrary.repository.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CartItemService {

    private final CartItemRepository cartItemRepository;

    @Transactional
    public boolean addCartItem(CartItem cartItem){
        return cartItemRepository.save(cartItem) != null;
    }

    @Transactional
    public void deleteCartItem(Long cartItemId){
        cartItemRepository.deleteById(cartItemId);
    }

}
