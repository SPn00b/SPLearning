package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.designpatterns.creational.*;
import org.example.solid.AbstractBird;
import org.example.solid.lsp.Flyable;
import org.example.solid.voilation.Bird;
import org.example.solid.voilation.BirdInterface;
import org.example.solid.voilation.Crow;
import org.example.solid.voilation.lsp.Penguin;

import java.time.Year;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        final Logger logger = LogManager.getLogger(Main.class);

        logger.info("Xmx: " + Runtime.getRuntime().maxMemory() / (1024 * 1024) + " MB");
        logger.info("current memory: " + Runtime.getRuntime().totalMemory() / (1024 * 1024) + " MB");
        logger.info("free memory: " + Runtime.getRuntime().freeMemory() / (1024 * 1024) + " MB");

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
        } catch (Exception e) {
            logger.error("Can Penguins fly, I did not see so in Bycalla zoo/Rani chi baug");
        }

        // Fix using LSP by making seperate class for Penguin with no association with Bird
        // seperate out flying and make bird class extend the flying one.
        Flyable flyableBirdLSP = new org.example.solid.lsp.Bird();
        flyableBirdLSP.fly();

        // Segregation Segregation principle
        org.example.solid.interfacesp.Bird birSegregationSegregationCrow = new org.example.solid.interfacesp.Crow();
        birSegregationSegregationCrow.fly();


        // Add DIP last principle call here for SOLID

        // Add Singleton Design Pattern call here

        // Will fail due to private constructor
        //SingletonDesignPattern singletonDesignPattern = new SingletonDesignPattern();
        SingletonDesignPattern singletonDesignPattern1 = SingletonDesignPattern.getInstance();
        SingletonDesignPattern.printSingleton();
        logger.info("Object hash code is " + singletonDesignPattern1.hashCode());
        SingletonDesignPattern singletonDesignPattern2 = SingletonDesignPattern.getInstance();
        logger.info("Object hash code is " + singletonDesignPattern2.hashCode());
        logger.info(singletonDesignPattern1);
        logger.info(singletonDesignPattern2);
        logger.info(singletonDesignPattern1 == singletonDesignPattern2);


        SingletonDesignPatternSynchronized singletonDesignPatternSynchronized1 = SingletonDesignPatternSynchronized.getInstance();
        SingletonDesignPatternSynchronized.printSingleton();
        logger.info("Object hash code is " + singletonDesignPatternSynchronized1.hashCode());
        SingletonDesignPatternSynchronized singletonDesignPatternSynchronized2 = SingletonDesignPatternSynchronized.getInstance();
        logger.info("Object hash code is " + singletonDesignPatternSynchronized2.hashCode());
        logger.info(singletonDesignPatternSynchronized1);
        logger.info(singletonDesignPatternSynchronized2);
        logger.info(singletonDesignPatternSynchronized1 == singletonDesignPatternSynchronized2);


        // Builder Design Pattern

        //Without Builder class
        BookWithoutBuilderDesignPattern bookWithoutBuilderDesignPattern1 = new BookWithoutBuilderDesignPattern("12345678912", "Title", "Genre", "Auther", Year.now(), "Description");
        logger.info(bookWithoutBuilderDesignPattern1.getIsbn());
        logger.info(bookWithoutBuilderDesignPattern1.getTitle());
        logger.info(bookWithoutBuilderDesignPattern1.getGenre());
        logger.info(bookWithoutBuilderDesignPattern1.getAuthor());
        logger.info(bookWithoutBuilderDesignPattern1.getPublished());
        logger.info(bookWithoutBuilderDesignPattern1.getDescription());

        //What if I want to set just few parameters here and not all at once?
        //Should I create multiple constructors or telescopic constructors? then there would be lots of constructors
        // mixing up of parameters if same datatype parameters are present in same constructor?
        BookWithoutBuilderDesignPattern bookWithoutBuilderDesignPattern2 = new BookWithoutBuilderDesignPattern(null, "Title", "Genre", "Auther", Year.now(), "Description");
        logger.info(bookWithoutBuilderDesignPattern2.getIsbn());
        logger.info(bookWithoutBuilderDesignPattern2.getTitle());
        logger.info(bookWithoutBuilderDesignPattern2.getGenre());
        logger.info(bookWithoutBuilderDesignPattern2.getAuthor());
        logger.info(bookWithoutBuilderDesignPattern2.getPublished());
        logger.info(bookWithoutBuilderDesignPattern2.getDescription());

        // Try validation before object creation?
        BookWithoutBuilderDesignPattern bookWithoutBuilderDesignPattern3 = new BookWithoutBuilderDesignPattern();
        try {
            bookWithoutBuilderDesignPattern3.createObject("12345678912", "Title", "Genre", "Auther", Year.now(), "Description");
        } catch (Exception e) {
            logger.error("Error in Book object ", e);
        }


        BookBuilderDesignPattern bookBuilderDesignPattern1 = new BookBuilderDesignPattern.Builder("123456789012", "Title").build();
        logger.info(bookBuilderDesignPattern1.getIsbn());
        logger.info(bookBuilderDesignPattern1.getTitle());
        logger.info(bookBuilderDesignPattern1.getGenre());
        logger.info(bookBuilderDesignPattern1.getAuthor());
        logger.info(bookBuilderDesignPattern1.getPublished());
        logger.info(bookBuilderDesignPattern1.getDescription());


        String query = SQLSelectWithWhereClauseQueryBuilder.builder()
                .withSelectClause("name")
                .withSelectClause("email")
                .withFromClause("users")
                .withFromClause("roles")
                .withWhereClause("age > 18")
                .withWhereClause("country = 'USA'")
                .build();

        logger.info("SQLSelectWithWhereClauseQueryBuilder query is " + query);

        logger.info("Xmx: " + Runtime.getRuntime().maxMemory() / (1024 * 1024) + " MB");
        logger.info("current memory: " + Runtime.getRuntime().totalMemory() / (1024 * 1024) + " MB");
        logger.info("free memory: " + Runtime.getRuntime().freeMemory() / (1024 * 1024) + " MB");

        // Factory Design Pattern

        FDPPaymentGatewayFactory factory = new FDPPayPalFactory();
        FDPPaymentProcessor paymentProcessor = new FDPPaymentProcessor(factory);
        Payment payment = new Payment("PayPal", 100.0, "USD");
        paymentProcessor.processPayment(payment);
        paymentProcessor.refundPayment(payment);

        logger.info("Xmx: " + Runtime.getRuntime().maxMemory() / (1024 * 1024) + " MB");
        logger.info("current memory: " + Runtime.getRuntime().totalMemory() / (1024 * 1024) + " MB");
        logger.info("free memory: " + Runtime.getRuntime().freeMemory() / (1024 * 1024) + " MB");

        // Factory Design Pattern

        ButtonFactoryPattern windowsButtonFactoryPattern = new WindowsButtonFactoryPattern();
        windowsButtonFactoryPattern.paint();

        ButtonFactoryPattern macButtonFactoryPattern = new MacButtonFactoryPattern();
        macButtonFactoryPattern.paint();

        CheckBoxFactoryDesignPattern windowsCheckBoxFactoryPattern = new WindowsCheckBoxFactoryDesignPattern();
        windowsCheckBoxFactoryPattern.paint();

        CheckBoxFactoryDesignPattern macCheckBoxFactoryPattern = new MacCheckBoxFactoryDesignPattern();
        macCheckBoxFactoryPattern.paint();

        logger.info("Xmx: " + Runtime.getRuntime().maxMemory() / (1024 * 1024) + " MB");
        logger.info("current memory: " + Runtime.getRuntime().totalMemory() / (1024 * 1024) + " MB");
        logger.info("free memory: " + Runtime.getRuntime().freeMemory() / (1024 * 1024) + " MB");

        // Abstract Factory Design Pattern
        logger.info("Abstract factory start");

        GUIAbstractFactoryDesignPattern windowsGUIAbstractFactoryDesignPattern = new WindowsGUIAbstractFactoryDesignPattern();
        windowsGUIAbstractFactoryDesignPattern.createButton().paint();
        windowsGUIAbstractFactoryDesignPattern.createCheckBox().paint();

        GUIAbstractFactoryDesignPattern macGUIAbstractFactoryDesignPattern = new MacGUIAbstractFactoryDesignPattern();
        macGUIAbstractFactoryDesignPattern.createButton().paint();
        macGUIAbstractFactoryDesignPattern.createCheckBox().paint();

        logger.info("Xmx: " + Runtime.getRuntime().maxMemory() / (1024 * 1024) + " MB");
        logger.info("current memory: " + Runtime.getRuntime().totalMemory() / (1024 * 1024) + " MB");
        logger.info("free memory: " + Runtime.getRuntime().freeMemory() / (1024 * 1024) + " MB");

        // 1. Create the Prototype (original object)
        DepartmentPrototypeShallow hrDept = new DepartmentPrototypeShallow("Human Resources", 101);
        EmployeePrototypeShallow originalEmployee = new EmployeePrototypeShallow(1, "Alice Smith", hrDept);

        logger.info("Original Employee (Prototype): " + originalEmployee);
        logger.info("Original Employee Dept HashCode: " + hrDept.hashCode());

        // 2. Client clones the prototype to create new objects
        EmployeePrototypeShallow clonedEmployee1 = null;
        EmployeePrototypeShallow clonedEmployee2 = null;

        try {
            clonedEmployee1 = (EmployeePrototypeShallow) originalEmployee.clone();
            clonedEmployee2 = (EmployeePrototypeShallow) originalEmployee.clone();
        } catch (CloneNotSupportedException e) {
            logger.error("Cloning not supported: " + e.getMessage());
        }

        logger.info("\nCloned Employee 1: " + clonedEmployee1);
        logger.info("Cloned Employee 1 Dept HashCode: " + clonedEmployee1.getDepartment().hashCode());

        logger.info("Cloned Employee 2: " + clonedEmployee2);
        logger.info("Cloned Employee 2 Dept HashCode: " + clonedEmployee2.getDepartment().hashCode());

        // --- Demonstrating Shallow Clone Behavior ---
        logger.info("\n--- Modifying Cloned Employee 1's Data ---");

        // Modify a primitive field (or immutable String) - this is safe
        clonedEmployee1.setId(2);
        clonedEmployee1.setName("Bob Johnson");

        // !!! IMPORTANT: Modify the shared Department object through clonedEmployee1
        clonedEmployee1.getDepartment().setName("Marketing"); // Changes the original's department too!
        clonedEmployee1.getDepartment().setDeptId(201); // Changes the original's department too!

        logger.info("\nOriginal Employee after modifications: " + originalEmployee);
        logger.info("Cloned Employee 1 after modifications: " + clonedEmployee1);
        logger.info("Cloned Employee 2 after modifications: " + clonedEmployee2); // Shows shared change

        logger.info("\nAre original and cloned department objects the same?");
        logger.info("Original.dept == Cloned1.dept: " + (originalEmployee.getDepartment() == clonedEmployee1.getDepartment()));
        logger.info("Cloned1.dept == Cloned2.dept: " + (clonedEmployee1.getDepartment() == clonedEmployee2.getDepartment()));

        logger.info("Xmx: " + Runtime.getRuntime().maxMemory() / (1024 * 1024) + " MB");
        logger.info("current memory: " + Runtime.getRuntime().totalMemory() / (1024 * 1024) + " MB");
        logger.info("free memory: " + Runtime.getRuntime().freeMemory() / (1024 * 1024) + " MB");


        // 1. Create the Prototype (original object)
        DepartmentPrototypeDeep hrDeptD = new DepartmentPrototypeDeep("Human Resources", 101);
        EmployeePrototypeDeep originalEmployeeD = new EmployeePrototypeDeep(1, "Alice Smith", hrDeptD);

        logger.info("Original Employee (Prototype): " + originalEmployeeD);
        logger.info("Original Employee Dept HashCode: " + hrDeptD.hashCode());

        // 2. Client clones the prototype to create new objects
        EmployeePrototypeDeep clonedEmployee1D = null;
        EmployeePrototypeDeep clonedEmployee2D = null;

        try {
            clonedEmployee1D = (EmployeePrototypeDeep) originalEmployeeD.clone();
            clonedEmployee2D = (EmployeePrototypeDeep) originalEmployeeD.clone();
        } catch (CloneNotSupportedException e) {
            logger.error("Cloning not supported: " + e.getMessage());
        }

        logger.info("\nCloned Employee 1: " + clonedEmployee1D);
        logger.info("Cloned Employee 1 Dept HashCode: " + clonedEmployee1D.getDepartment().hashCode());

        logger.info("Cloned Employee 2: " + clonedEmployee2D);
        logger.info("Cloned Employee 2 Dept HashCode: " + clonedEmployee2D.getDepartment().hashCode());

        // --- Demonstrating Deep Clone Behavior ---
        logger.info("\n--- Modifying Cloned Employee 1's Data ---");

        // Modify a primitive field (or immutable String) - this is safe
        clonedEmployee1D.setId(2);
        clonedEmployee1D.setName("Bob Johnson");

        // !!! IMPORTANT: Modify the Department object through clonedEmployee1
        // This will ONLY affect clonedEmployee1's department
        clonedEmployee1D.getDepartment().setName("Marketing");
        clonedEmployee1D.getDepartment().setDeptId(201);

        logger.info("\nOriginal Employee after modifications: " + originalEmployeeD);
        logger.info("Cloned Employee 1 after modifications: " + clonedEmployee1D);
        logger.info("Cloned Employee 2 after modifications: " + clonedEmployee2D); // Shows no shared change

        logger.info("\nAre original and cloned department objects the same?");
        logger.info("Original.dept == Cloned1.dept: " + (originalEmployeeD.getDepartment() == clonedEmployee1D.getDepartment()));
        logger.info("Cloned1.dept == Cloned2.dept: " + (clonedEmployee1D.getDepartment() == clonedEmployee2D.getDepartment()));

        logger.info("Xmx: " + Runtime.getRuntime().maxMemory() / (1024 * 1024) + " MB");
        logger.info("current memory: " + Runtime.getRuntime().totalMemory() / (1024 * 1024) + " MB");
        logger.info("free memory: " + Runtime.getRuntime().freeMemory() / (1024 * 1024) + " MB");
    }
}