package com.workspaceit.dao;

import com.workspaceit.entity.Admin;
import com.workspaceit.entity.Customer;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao extends BaseDao{

    public Admin checkLogin(String uname, String pass) {

        try {
            String hql = "from Admin WHERE username=:uname and password=:pass";
            Session session = this.getCurrentHibernateSession();
            return (Admin) session.createQuery(hql).setParameter("uname", uname).setParameter("pass", pass).uniqueResult();

        }

        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
