package com.workspaceit.service;
import com.workspaceit.dao.CartDao;
import com.workspaceit.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartService {

    @Autowired
    private CartDao cartDao;

    public Boolean addToCart(Cart cart) {
        return this.cartDao.addToCart(cart);
    }

    public Object userCartDetails(int uId) {
        return this.cartDao.userCartDetails(uId);
    }
}
