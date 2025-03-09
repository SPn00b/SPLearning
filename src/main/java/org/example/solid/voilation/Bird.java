package org.example.solid.voilation;

public class Bird {
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

    public void flying(birdType bT) {
        switch (bT) {
            case PIEGON:
                System.out.println("Pigeon is flying");
                break;
            case CROW:
                System.out.println("Crow is flying");
                break;
            case SPARROW:
                System.out.println("Sparrow is flying");
                break;
            case DUCK:
                System.out.println("Duck is flying");
                break;
        }
    }

    public void makeSound(birdType bT) {
        switch (bT) {
            case PIEGON:
                System.out.println("Coo coo"); // Corrected sound
                break;
            case CROW:
                System.out.println("Kaw kaw");
                break;
            case SPARROW:
                System.out.println("Chirp chirp"); // Corrected sound
                break;
            case DUCK:
                System.out.println("Quack quack"); // Corrected sound
                break;
        }
    }
}
