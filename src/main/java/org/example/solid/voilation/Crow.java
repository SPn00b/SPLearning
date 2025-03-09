package org.example.solid.voilation;

public class Crow implements BirdInterface {

    @Override
    public void flying(BirdInterface.birdType bT) {
        switch (bT) {
            case CROW:
                System.out.println("Crow is flying");
                break;
        }
    }

    @Override
    public void makeSound(BirdInterface.birdType bT) {
        switch (bT) {
            case CROW:
                System.out.println("Kaw kaw");
                break;
        }
    }

    public void getHeight() {
        System.out.println("Crow is of height "+BirdInterface.height+" cm");
    }
}
