package com.workspaceit.dao;
import com.workspaceit.entity.Cart;
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

    public Object userCartDetails(int uId) {
        try {
            String query = "select f.image, f.typeName, c.quantity, c.totalPrice from FoodItems f " +
                    "join Cart c on f.id=c.foodTypeId where c.customerId=:u_id";
            Session session = this.getCurrentHibernateSession();
            List<Object> cart = session.createQuery(query).setParameter("u_id", uId).list();
            return  cart;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
