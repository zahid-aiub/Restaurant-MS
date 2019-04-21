package com.workspaceit.dao;

import com.workspaceit.entity.Customer;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;

@Repository
public class CustomerDao extends BaseDao {

    public Boolean add(Customer customer) {
        try {
            Session session = this.getCurrentHibernateSession();
             session.save(customer);
             return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public Customer checkLogin(String uname, String pass) {

        try {
            String hql = "from Customer WHERE phone=:phone and password=:pass";
            Session session = this.getCurrentHibernateSession();
            return (Customer) session.createQuery(hql).setParameter("phone", uname).setParameter("pass", pass).uniqueResult();

        }

        catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
