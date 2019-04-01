package com.workspaceit.dao;
import com.workspaceit.entity.Cart;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class CartDao extends BaseDao{

    public Boolean addToCart(Cart cart) {
        try {
            Session session = this.getCurrentHibernateSession();
            session.save(cart);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
