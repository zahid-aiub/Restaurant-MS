package com.workspaceit.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Service;


public interface BaseDao {
    Object save(Object obj);
    boolean update(Object obj);
    boolean delete(Object obj) throws Exception;
}
