package com.workspaceit.dao;

import com.workspaceit.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp extends BaseDaoImp implements UserDao {

    public List<User> getAllUsers() {
        List<User> userList = super.getCurrentHibernateSession().createQuery("from User").list();
        return userList;
    }
}