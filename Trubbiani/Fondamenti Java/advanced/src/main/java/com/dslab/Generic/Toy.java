package com.dslab.Generic;

import com.dslab.Generic.Interfaces.IProduct;

public class Toy implements IProduct<Toy> {

    private String name;
    private double price;

    public Toy() {
    }

    public Toy(String name, double price) {
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
    public Toy getProductType() {
        return this;
    }

    @Override
    public Toy deepCopy() {
        try {
            Toy clonedObj = (Toy) super.clone();
            return clonedObj;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

}
