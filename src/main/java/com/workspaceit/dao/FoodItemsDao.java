package com.workspaceit.dao;

import com.workspaceit.entity.FoodItems;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FoodItemsDao extends BaseDao{

    public List<FoodItems> getAllByCategory(String category) {
        try {
            String query = "from FoodItems WHERE category=:category";
            Session session = this.getCurrentHibernateSession();
            return session.createQuery(query).setParameter("category", category).list();
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

}
