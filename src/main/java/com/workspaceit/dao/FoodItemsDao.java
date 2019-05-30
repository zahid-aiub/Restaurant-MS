package com.workspaceit.dao;

import com.workspaceit.entity.FoodItems;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FoodItemsDao extends BaseDao{

    public List<FoodItems> getAllByCategory(String category, String userType) {
        try {
            String query="";
            if (userType.equals("customer")){
                query = "from FoodItems WHERE category=:category and status=:stts";
                Session session = this.getCurrentHibernateSession();
                return session.createQuery(query).setParameter("category", category)
                        .setParameter("stts", 1).list();
            }
            else {
                query = "from FoodItems WHERE category=:category";
                Session session = this.getCurrentHibernateSession();
                return session.createQuery(query).setParameter("category", category).list();
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public FoodItems getItemByid(int id) {
        try {
            String query = "from FoodItems WHERE id=:id";
            Session session = this.getCurrentHibernateSession();
            return (FoodItems) session.createQuery(query).setParameter("id", id).uniqueResult();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public int getQuantity(int foodId) {
        try {
            String query = "select F.quantity from FoodItems F WHERE id=:foodId";
            Session session = this.getCurrentHibernateSession();
            return (Integer) session.createQuery(query).setParameter("foodId", foodId).uniqueResult();
        }
        catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
    }

    public Integer updateQuantity(int updatedQuantity, int foodId) {
        try {
            System.out.println("FoodId: "+ foodId + "Qty: "+updatedQuantity);
            String query = "update FoodItems F set F.quantity=:updatedQuantity WHERE id=:foodId";
            Session session = this.getCurrentHibernateSession();
            return session.createQuery(query)
                    .setParameter("updatedQuantity", updatedQuantity)
                    .setParameter("foodId", foodId).executeUpdate();
        }
        catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
    }

    public Integer updateStatus (int status, int foodId) {
        try {

            String query = "update FoodItems F set F.status=:status WHERE id=:foodId";
            Session session = this.getCurrentHibernateSession();
            return session.createQuery(query)
                    .setParameter("status", status)
                    .setParameter("foodId", foodId).executeUpdate();
        }
        catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
    }

    public FoodItems fetchProductById(int foodId) {
        try {
            String query = "from FoodItems WHERE id=:foodId";
            Session session = this.getCurrentHibernateSession();
            return (FoodItems) session.createQuery(query).setParameter("foodId", foodId).uniqueResult();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Integer batchUpdate(int foodId, int qnty, int price, String desc) {
        try {

//            String query1 = "UPDATE food_items SET price=5012, quantity=100 WHERE id=2";
            String query = "UPDATE food_items SET quantity="+qnty+", price="+price+" WHERE id="+foodId+"";
            Session session = this.getCurrentHibernateSession();
            return session.createNativeQuery(query).executeUpdate();

        }
        catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
    }
}
