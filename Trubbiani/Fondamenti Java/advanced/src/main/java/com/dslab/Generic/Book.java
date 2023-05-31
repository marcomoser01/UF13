package com.dslab.Generic;

import com.dslab.Generic.Interfaces.IProduct;

public class Book implements IProduct<Book> {

    private String name;
    private double price;

    public Book() {
    }

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public Book getProductType() {
        return this;
    }

    @Override
    public Book deepCopy() {
        try {
            Book clonedObj = (Book) super.clone();
            return clonedObj;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

}
