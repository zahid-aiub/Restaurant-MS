package com.workspaceit.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "card", schema = "restaurant", catalog = "")
public class Card {
    private int id;
    private int quantity;
    private int totalPrice;
    private int foodTypeId;
    private int customerId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "total_price")
    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Basic
    @Column(name = "food_type_id")
    public int getFoodTypeId() {
        return foodTypeId;
    }

    public void setFoodTypeId(int foodTypeId) {
        this.foodTypeId = foodTypeId;
    }

    @Basic
    @Column(name = "customer_id")
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return id == card.id &&
                quantity == card.quantity &&
                totalPrice == card.totalPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, totalPrice);
    }


}
