package it.altaformazione.solution1;

public class Cat extends Animal {

    public static int totalCats = 0;

    private final String name;
    private final String race;

    public Cat(String name, String race) {
        super(); // call parent class

        totalCats += 1;

        this.name = name;
        this.race = race;
    }

    @Override
    public void sound() {
        System.out.println("The cat meows");
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }
}
