package it.altaformazione.example1;

public class Box<T> {

    // The Final keywoard make the value assignable only one time. \
    // YOU CANNOT MODIFY THE VALUE ONCE AS BEEN ASSIGNED!
    final T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    // public void change(T value){
    // this.value = value;
    // }

}
