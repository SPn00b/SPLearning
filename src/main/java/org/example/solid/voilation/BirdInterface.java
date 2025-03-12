package org.example.solid.voilation;

public interface BirdInterface {
        // variables declared inside interface are final (cannot be changed)
        // and
        // static (Same values for all classes inheriting this interface).
        String color = "RED";
        int weight = 200;
        int height = 15;
        int width = 15;
        int length = 30;
        public enum birdType {
            PIEGON,
            CROW,
            SPARROW,
            DUCK
        }

        public void flying(org.example.solid.voilation.BirdInterface.birdType bT);

        public void makeSound(org.example.solid.voilation.BirdInterface.birdType bT);
    }
