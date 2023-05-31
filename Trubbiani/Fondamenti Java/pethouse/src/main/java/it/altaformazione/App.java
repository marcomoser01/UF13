package it.altaformazione;

import it.altaformazione.solution1.Animal;
import it.altaformazione.solution1.Cat;
import it.altaformazione.solution1.Dog;
import it.altaformazione.solution2.PetManager;

/**
 * Pet Store
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Welcome in our pet store!!!");

        Animal animal = new Animal();
        Cat cat = new Cat("Fluffy", "Persiano");
        Dog dog = new Dog("Birra", "Border Collie");

        System.out.println("Total Animals: " + Animal.totalAnimals);
        System.out.println("Total Dogs: " + Dog.totalDogs);
        System.out.println("Total Cats: " + Cat.totalCats);

        it.altaformazione.solution2.Dog dog1 = PetManager.createDog();
        it.altaformazione.solution2.Dog dog2 = PetManager.createDog();
        it.altaformazione.solution2.Cat cat1 = PetManager.createCat();

        System.out.println("----------------------------------");
        System.out.println("Available animals in our Pet Store");

        System.out.println("Total Animals: " + PetManager.getTotalAnimal());
        System.out.println("Total Dogs: " + PetManager.getTotalDogs());
        System.out.println("Total Cats: " + PetManager.getTotalCats());

    }
}
