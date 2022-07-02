package com.example.model;

import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="brand")
    private String brand;

    @Column(name="madein")
    private String madein;

    @Column(name="price")
    private float price;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
    public Product() {
    }

    public Product(String name, String brand, String madein, float price) {
        this.name = name;
        this.brand = brand;
        this.madein = madein;
        this.price = price;
    }

    public Product(int id, String name, String brand, String madein, float price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.madein = madein;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMadein() {
        return madein;
    }

    public void setMadein(String madein) {
        this.madein = madein;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
