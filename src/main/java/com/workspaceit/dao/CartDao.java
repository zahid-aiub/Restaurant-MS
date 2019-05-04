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

    public Integer getFoodTypeId(int foodId) {
        try {
            String query = "select foodTypeId from Cart WHERE id=:f_id";
            Session session = this.getCurrentHibernateSession();
            return (Integer) session.createQuery(query)
                    .setParameter("f_id", foodId).uniqueResult();
        }
        catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
    }

    public Integer getQuantity(int foodId) {
        try {
            String query = "select quantity from Cart WHERE id=:f_id";
            Session session = this.getCurrentHibernateSession();
            return (Integer) session.createQuery(query)
                    .setParameter("f_id", foodId).uniqueResult();
        }
        catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
    }

    public Integer removeFromCart(int foodId) {
        try {
            String query = "delete FROM cart where id ="+foodId+"";
            Session session = this.getCurrentHibernateSession();
            session.createNativeQuery(query).executeUpdate();
            return 1;
        }
        catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
    }
}
