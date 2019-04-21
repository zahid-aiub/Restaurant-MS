package com.workspaceit.dao;
import com.workspaceit.entity.Cart;
import com.workspaceit.entity.Helper;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<Cart> userCartDetails(int uId) {
        try {
            String query = "from Cart WHERE customerId=:c_Id";
            Session session = this.getCurrentHibernateSession();
            return session.createQuery(query).setParameter("c_Id", uId).list();


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
