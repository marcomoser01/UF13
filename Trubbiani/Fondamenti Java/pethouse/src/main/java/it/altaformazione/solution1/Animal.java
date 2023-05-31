package it.altaformazione.solution1;

public class Animal {
    public static int totalAnimals = 0;

    public Animal() {
        totalAnimals += 1;
    }

    public void sound() {
        System.out.println("The animal makes a sound");
    }
}
