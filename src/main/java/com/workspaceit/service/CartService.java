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

    public List<Cart> userCartDetails(int uId) {
        return this.cartDao.userCartDetails(uId);
    }

    public Integer getFoodTypeId(int foodId) {
        return this.cartDao.getFoodTypeId(foodId);
    }

    public Integer getQuantity(int foodId) {
        return this.cartDao.getQuantity(foodId);
    }

    public Integer removeFromCart(int foodId) {
        return this.cartDao.removeFromCart(foodId);
    }
}
