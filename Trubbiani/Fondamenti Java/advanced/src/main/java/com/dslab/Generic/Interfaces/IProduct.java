package com.dslab.Generic.Interfaces;

public interface IProduct<T> extends Cloneable {
    void setName(String name);

    String getName();

    void setPrice(double price);

    double getPrice();

    T getProductType();

    T deepCopy();
}
