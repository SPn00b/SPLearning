package org.example.solid.voilation;

public interface BirdInterface {
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
