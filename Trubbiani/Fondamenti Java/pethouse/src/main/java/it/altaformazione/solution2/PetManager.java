package it.altaformazione.solution2;

public class PetManager {
    private static int totalCats = 0;
    private static int totalDogs = 0;

    public PetManager() {
    }

    public static Dog createDog() {
        totalDogs++;
        return new Dog();
    }

    public static Cat createCat() {
        totalCats++;
        return new Cat();
    }

    public static int getTotalCats() {
        return totalCats;
    }

    public static int getTotalDogs() {
        return totalDogs;
    }

    public static int getTotalAnimal() {
        return totalCats + totalDogs;
    }

}
