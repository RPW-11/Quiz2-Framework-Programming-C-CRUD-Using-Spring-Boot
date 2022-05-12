package com.quiz2.quiz2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private double price;
    private String description;

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String desc){
        this.description = desc;
    }
}
