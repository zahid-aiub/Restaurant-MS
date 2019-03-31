package com.workspaceit.dao;
import com.workspaceit.entity.Cart;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class CartDao extends BaseDao{

    public Cart addToCart(Cart cart) {
        try {
            Session session = this.getCurrentHibernateSession();
            session.save(cart);
            return cart;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
