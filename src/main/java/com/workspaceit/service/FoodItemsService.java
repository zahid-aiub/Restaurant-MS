package com.workspaceit.service;

import com.workspaceit.dao.FoodItemsDao;
import com.workspaceit.entity.FoodItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FoodItemsService {

    @Autowired
    private FoodItemsDao foodItemsDao;

    public List<FoodItems> getAllByCategory(String category, String userType) {
        return this.foodItemsDao.getAllByCategory(category, userType);
    }

    public FoodItems getItemByid(int id) {
        return this.foodItemsDao.getItemByid(id);
    }

    public int getQuantity(int foodId) {
        return foodItemsDao.getQuantity(foodId);
    }

    public Integer updateQuantity(int updatedQuantity, int foodId) {
        return this.foodItemsDao.updateQuantity(updatedQuantity, foodId);
    }

    public Integer updateStatus (int status, int foodId) {
        return this.foodItemsDao.updateStatus(status, foodId);
    }

    public FoodItems fetchProductById ( int foodId) {
        return this.foodItemsDao.fetchProductById(foodId);
    }

    public Integer updateBatch(Integer foodId, Integer qnty, Integer price, String desc) {
        return this.foodItemsDao.batchUpdate(foodId, qnty, price, desc);
    }
}
