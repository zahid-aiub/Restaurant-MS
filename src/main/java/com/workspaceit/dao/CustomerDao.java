package com.workspaceit.dao;

import com.workspaceit.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao extends BaseDao {

    public Object add (Customer customer) {
        return save(customer);
    }
}
