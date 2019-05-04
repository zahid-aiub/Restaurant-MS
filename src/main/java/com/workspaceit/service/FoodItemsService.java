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

    public List<FoodItems> getAllByCategory(String category) {
        return this.foodItemsDao.getAllByCategory(category);
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
}
