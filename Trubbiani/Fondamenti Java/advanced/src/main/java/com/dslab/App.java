package com.dslab;

import com.dslab.Generic.Book;
import com.dslab.Generic.ShoppingCart;
// import com.dslab.Objects.Book;
import com.dslab.Generic.Toy;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        // Book book1 = new Book();

        // // Print the number of available book
        // System.out.println("[Book 1] We have, " + book1.availableBook() + "
        // available!");

        // Book book2 = new Book("Da Vinci Code");
        // System.out.println("[Book 2] We have, " + book2.availableBook() + "
        // available!");

        // // If now I print book1.availableBook() what do you think will be the result
        // ? 1
        // // or 2 ?
        // System.out.println("[Book 1] We have, " + book1.availableBook() + "
        // available!");

        // // what happen if we print book2.title ?
        // book1.setTitle("Il nome della rosa");
        // System.out.println(book1.getTitle());

        // // what happen if we print book1.title ?
        // System.out.println(book2.getTitle());

        /**
         * Shopping Cart test
         */
        ShoppingCart shoppingCart = new ShoppingCart();
        Book book = new Book("Il codice da vinci", 10.0);
        Toy toy = new Toy("Lego Star Wars", 100.0);

        shoppingCart.addProduct(book);
        shoppingCart.addProduct(book); // What if we add the book using book.deepCopy() method?
        shoppingCart.addProduct(toy);

        System.out.println("\n========================= CART ==========================\n");
        // print items in shopping cart
        shoppingCart.printProducts();

        System.out.println("\n==========================================================\n");
        System.out.println("Number of items in shopping cart: ");
        System.out.println(shoppingCart.getNumberOfItems());

        // try to delete Toy item
        shoppingCart.removeProduct(toy);

        System.out.println("Number of items in shopping cart: ");
        System.out.println(shoppingCart.getNumberOfItems());

        // What happen if we delete the book?
        shoppingCart.removeProduct(book);
        System.out.println("Number of items in shopping cart: ");
        System.out.println(shoppingCart.getNumberOfItems());

    }

}
