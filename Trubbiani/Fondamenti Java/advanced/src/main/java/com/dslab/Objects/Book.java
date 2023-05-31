package com.dslab.Objects;

import com.dslab.Interfaces.IBook;

/**
 * This class define a Book Object with two field ( title e author ).
 * As we can see title is a simple string but what is Author????
 * 
 * 
 * 
 * public: The code is accessible for all classes
 * private: The code is only accessible within the declared class
 * 
 * default: The code is only accessible in the same package. This is used when
 * you don't specify a modifier. You will learn more about packages in the
 * Packages chapter
 * 
 * protected: The code is accessible in the same package and subclasses. You
 * will learn more about subclasses and superclasses in the Inheritance chapter
 * 
 */
public class Book implements IBook {

    private static int availableBooks = 0; // The static keyword implies that this variable is shared between all
                                           // instance of the Book object

    // [Modifier] [Type] [Variable Name]
    private String title;

    // In this declaration we say that Book should also contain an author.
    public Author author;

    // Costructor
    public Book() {
        Book.availableBooks += 1;
    }

    // Constructor
    public Book(String title) {
        this.title = title;
        Book.availableBooks += 1;
    }

    // Constructor
    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
        Book.availableBooks += 1;
    }

    @Override
    public int availableBook() {
        return Book.availableBooks;
    }

    // Getter and Setter methods
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
