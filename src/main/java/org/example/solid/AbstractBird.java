package org.example.solid;

public abstract class AbstractBird {
    String color;
    int weight;
    int height;
    int width;
    int length;
    public enum birdType {
        PIEGON,
        CROW,
        SPARROW,
        DUCK
    }

    public abstract void flying();

    public abstract void makeSound();
}
