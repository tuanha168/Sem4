package com.example.model;

import javax.persistence.*;

@Entity
@Table(name="tbProducts")
public class Products {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="amount")
    private int amount;

    @Column(name="details")
    private String details;

    @Column(name="price")
    private float price;

    public Products() {
    }

    public Products(String name, int amount, String details, float price) {
        this.name = name;
        this.amount = amount;
        this.details = details;
        this.price = price;
    }

    public Products(int id, String name, int amount, String details, float price) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.details = details;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
