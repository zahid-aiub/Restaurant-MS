package com.workspaceit.service;
import com.workspaceit.dao.CartDao;
import com.workspaceit.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CartService {

    @Autowired
    private CartDao cartDao;

    public Cart addToCart(Cart cart) {
        return this.cartDao.addToCart(cart);
    }
}
