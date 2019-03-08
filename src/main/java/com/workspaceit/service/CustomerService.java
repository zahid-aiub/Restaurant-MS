package com.workspaceit.service;

import com.workspaceit.dao.BaseDao;
import com.workspaceit.dao.CustomerDao;
import com.workspaceit.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService extends BaseDao {

    @Autowired
    private CustomerDao customerDao;

    public Object add (Customer customer){
        return this.customerDao.add(customer);
    }
}
