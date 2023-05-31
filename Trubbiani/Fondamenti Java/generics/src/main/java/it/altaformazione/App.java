package it.altaformazione;

import java.util.HashMap;
import java.util.Map;

import it.altaformazione.example1.Box;

/**
 * Generics
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("==================== Generics ====================");

        Box<String> box1 = new Box<String>("I'am a cow!");

        System.out.println(box1.getValue());

        Box<Integer> box2 = new Box<Integer>(1);

        System.out.println(box2.getValue());
    }
}
