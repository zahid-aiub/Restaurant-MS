package com.workspaceit.dao;

import com.workspaceit.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * REST OF THE BASIC FUNCTIONALITIES ARE INCLUDED IN BASE DAO
 * ADD USER RELATED ADDITIONAL METHOD PROTOTYPES HERE
 */

public interface UserDao extends BaseDao {
    List<User> getAllUsers();
}
