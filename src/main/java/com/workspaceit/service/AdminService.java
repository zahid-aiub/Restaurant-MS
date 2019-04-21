package com.workspaceit.service;

import com.workspaceit.dao.AdminDao;
import com.workspaceit.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    public Admin checkLogin(String uname, String pass){

        return this.adminDao.checkLogin(uname, pass);
    }

}
