package it.altaformazione.solution1;

public class Dog extends Animal {

    public static int totalDogs = 0;

    private final String name;
    private final String race;

    public Dog(String name, String race) {
        super();

        totalDogs += 1;

        this.name = name;
        this.race = race;
    }

    @Override
    public void sound() {
        System.out.println("The dog barks");
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }
}
