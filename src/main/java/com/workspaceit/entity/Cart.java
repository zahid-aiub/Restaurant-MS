package com.workspaceit.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cart")
public class Cart {
    private int id;
    private Integer customerId;
    private Integer quantity;
    private Integer totalPrice;
    private String foodTypeName;
    private String image;
    private Integer foodTypeId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "customer_id")
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "total_price")
    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Basic
    @Column(name = "food_type_name")
    public String getFoodTypeName() {
        return foodTypeName;
    }

    public void setFoodTypeName(String foodTypeName) {
        this.foodTypeName = foodTypeName;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "food_type_id")
    public Integer getFoodTypeId() {
        return foodTypeId;
    }

    public void setFoodTypeId(Integer foodTypeId) {
        this.foodTypeId = foodTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return id == cart.id &&
                Objects.equals(customerId, cart.customerId) &&
                Objects.equals(quantity, cart.quantity) &&
                Objects.equals(totalPrice, cart.totalPrice) &&
                Objects.equals(foodTypeName, cart.foodTypeName) &&
                Objects.equals(image, cart.image) &&
                Objects.equals(foodTypeId, cart.foodTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, quantity, totalPrice, foodTypeName, image, foodTypeId);
    }
}
