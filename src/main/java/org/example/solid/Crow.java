package org.example.solid;

public class Crow extends AbstractBird{
    @Override
    public void flying() {
        System.out.println("Crow is flying");
    }

    @Override
    public void makeSound() {
        System.out.println("Kaw Kaw");
    }

    public  void getHeight() {
        height = 20;
        System.out.println("height of Crow is "+height+ " cm");
    }
}
