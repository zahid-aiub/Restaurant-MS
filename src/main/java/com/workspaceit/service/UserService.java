package com.workspaceit.service;

import com.workspaceit.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User save (User user);
    boolean update(User user);
    boolean delete(User user) throws Exception;
    List<User> getAllUsers();
}
