package com.dslab.Generic.Interfaces;

public interface IShoppingCart {
    <T> void addProduct(IProduct<T> product);

    <T> void removeProduct(IProduct<T> product);

    double getTotalPrice();

    int getNumberOfItems();

    void printProducts();
}
