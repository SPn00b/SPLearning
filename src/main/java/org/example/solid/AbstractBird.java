package org.example.solid;

public abstract class AbstractBird {
    // Follows O principle in SOLID
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

    // again 2 methods break the SRP in the child overriden class
    public abstract void flying();

    public abstract void makeSound();
}
