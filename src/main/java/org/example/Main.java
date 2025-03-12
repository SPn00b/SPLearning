package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.solid.AbstractBird;
import org.example.solid.lsp.Flyable;
import org.example.solid.voilation.Bird;
import org.example.solid.voilation.BirdInterface;
import org.example.solid.voilation.Crow;
import org.example.solid.voilation.lsp.Penguin;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        final Logger logger = LogManager.getLogger(Main.class);
        //System.out.println(logger.getLevel());
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        //System.out.printf("Hello and welcome!");
        logger.info("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            //System.out.println("i = " + i);
            logger.info("i = " + i);
        }

        // SRP voilation due to 2 methods flying and sound as well as each method
        // has all its type in compared like an if else ladder
        Bird bird = new Bird();
        bird.flying(Bird.birdType.CROW);
        bird.makeSound(Bird.birdType.CROW);
        //add getter setter to get and set the class/instance variables

        // SRP voilation same as above, we have interface making it imposible to change
        // or
        // have different states due to being final and static by default
        BirdInterface birdInterfaceCrow = new Crow();
        birdInterfaceCrow.flying(BirdInterface.birdType.CROW);
        birdInterfaceCrow.makeSound(BirdInterface.birdType.CROW);
        ((Crow) birdInterfaceCrow).getHeight();

        // OCP as a solution for SRP
        // here we fix the if else ladder issue of SRP (2 methods SRP is still present)
        AbstractBird abstractBirdCrow = new org.example.solid.Crow();
        abstractBirdCrow.flying();
        abstractBirdCrow.makeSound();

        // LSP principle voilation in SOLID
        org.example.solid.voilation.lsp.Bird birdPenguin = new Penguin();
        try {
            birdPenguin.fly();
        }
        catch (Exception e) {
            logger.error("Can Penguins fly, I did not see so in Bycalla zoo/Rani chi baug");
        }

        // Fix using LSP by making seperate class for Penguin with no association with Bird
        // seperate out flying and make bird class extend the flying one.
        Flyable flyableBirdLSP = new org.example.solid.lsp.Bird();
        flyableBirdLSP.fly();

        // Segregation Segregation principle
        org.example.solid.interfacesp.Bird birSegregationSegregationCrow = new org.example.solid.interfacesp.Crow();
        birSegregationSegregationCrow.fly();

    }
}