package com.dslab.Generic;

import java.util.ArrayList;
import java.util.List;

import com.dslab.Generic.Interfaces.IProduct;
import com.dslab.Generic.Interfaces.IShoppingCart;

public class ShoppingCart implements IShoppingCart {

    private List<IProduct<?>> products = new ArrayList<>();

    public List<IProduct<?>> getProducts() {
        return products;
    }

    @Override
    public <T> void addProduct(IProduct<T> product) {
        this.products.add(product);
    }

    @Override
    public <T> void removeProduct(IProduct<T> product) {
        this.products.removeIf(p -> p.equals(product));
    }

    @Override
    public double getTotalPrice() {
        return this.products.stream()
                .map(p -> p.getPrice())
                .reduce(0D, (total, product) -> total + product);
    }

    @Override
    public int getNumberOfItems() {
        return this.products.size();
    }

    @Override
    public void printProducts() {
        for (IProduct<?> product : products) {
            System.out.println(product.getName() + " - " + product.getPrice() + " - "
                    + product.getProductType().getClass().getSimpleName());
        }
    }

}
