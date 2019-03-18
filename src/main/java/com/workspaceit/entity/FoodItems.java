package com.workspaceit.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "food_items", schema = "restaurant", catalog = "")
public class FoodItems {
    private int id;
    private String typeName;
    private int quantity;
    private String category;
    private int price;
    private int status;
    private String image;
    private String desc;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type_name")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
    @Column(name = "category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
    @Column(name = "desc")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodItems foodItems = (FoodItems) o;
        return id == foodItems.id &&
                quantity == foodItems.quantity &&
                price == foodItems.price &&
                status == foodItems.status &&
                Objects.equals(typeName, foodItems.typeName) &&
                Objects.equals(category, foodItems.category) &&
                Objects.equals(image, foodItems.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeName, quantity, category, price, status, image);
    }
}
