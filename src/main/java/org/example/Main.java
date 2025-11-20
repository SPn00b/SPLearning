package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.collection.map.HashMapWithSizeCheck;
import org.example.collection.map.HashMapWithSizeCheckCustomHashCode;
import org.example.designpatterns.creational.*;
import org.example.designpatterns.structural.*;
import org.example.dsa.recursion.Basic;
import org.example.multithreading.ThreadTesting;
import org.example.solid.AbstractBird;
import org.example.solid.lsp.Flyable;
import org.example.solid.voilation.Bird;
import org.example.solid.voilation.BirdInterface;
import org.example.solid.voilation.Crow;
import org.example.solid.voilation.lsp.Penguin;
import org.example.utils.RandomUtil;

import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

//    Adaptor Structural Design Pattern

        // Round fits round, no surprise.
        RoundHoleAdaptorStructuralPattern hole = new RoundHoleAdaptorStructuralPattern(5);
        RoundPegAdaptorStructuralPattern rpeg = new RoundPegAdaptorStructuralPattern(5);
        if (hole.fits(rpeg)) {
            logger.info("Round peg r5 fits round hole r5.");
        }

        SquarePegAdaptorStructuralPattern smallSqPeg = new SquarePegAdaptorStructuralPattern(2);
        SquarePegAdaptorStructuralPattern largeSqPeg = new SquarePegAdaptorStructuralPattern(20);
        // hole.fits(smallSqPeg); // Won't compile.

        // Adapter solves the problem.
        SquarePegAdaptorAdapterStructuralPattern smallSqPegAdapter = new SquarePegAdaptorAdapterStructuralPattern(smallSqPeg);
        SquarePegAdaptorAdapterStructuralPattern largeSqPegAdapter = new SquarePegAdaptorAdapterStructuralPattern(largeSqPeg);
        if (hole.fits(smallSqPegAdapter)) {
            logger.info("Square peg w2 fits round hole r5.");
        }
        if (!hole.fits(largeSqPegAdapter)) {
            logger.info("Square peg w20 does not fit into round hole r5.");
        }


        logger.info("Xmx: " + Runtime.getRuntime().maxMemory() / (1024 * 1024) + " MB");
        logger.info("current memory: " + Runtime.getRuntime().totalMemory() / (1024 * 1024) + " MB");
        logger.info("free memory: " + Runtime.getRuntime().freeMemory() / (1024 * 1024) + " MB");

//      Bridge Pattern

        DrawingAPI1Bridge api1 = new DrawingAPI1Bridge();
        DrawingAPIBridge api2 = new DrawingAPI2Bridge();

        ShapeBridge circle = new CircleBridge(1, 2, 3, api1);
        ShapeBridge square = new SquareBridge(4, 5, 6, api2);

        circle.draw(); // Output: API1: Drawing circle at (1, 2) with radius 3
        square.draw(); // Output: API2: Drawing square at (4, 5) with side length 6

        Basic recursion = new Basic();
        recursion.recursion(1);
        recursion.printNumbers(5);

        ThreadTesting threadTesting1 = new ThreadTesting();
        Thread thread1 = new Thread(threadTesting1);
        thread1.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Thread thread2 = new Thread(threadTesting1);
        Thread thread3 = new Thread(threadTesting1);

        thread2.start();
        thread3.start();

        try {
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        int numberOfVirtualThreads = 1000; // Define how many virtual threads you want to create

        // --- Method 1: Using Thread.ofVirtual().start() directly ---
        // This approach gives you direct control over each Thread object.
        // It's suitable when you need to manage individual thread lifecycles.
        logger.info("\n--- Method 1: Direct Virtual Thread Creation ---");
        List<Thread> threads = new ArrayList<>();
        long startTimeDirect = System.currentTimeMillis();

        for (int i = 0; i < numberOfVirtualThreads; i++) {
            // Create a new instance of ThreadTesting for each virtual thread.
            // This ensures each thread has its own 'count' variable.
            ThreadTesting task = new ThreadTesting();

            // Create and start a new virtual thread, giving it a custom name.
            // The 'task' (which implements Runnable) will be executed by this virtual thread.
            Thread virtualThread = Thread.ofVirtual()
                    .name("my-virtual-thread-" + i) // Assign a descriptive name
                    .start(task); // Start the virtual thread
            threads.add(virtualThread); // Add to list to wait for completion later
        }

        // Wait for all directly created virtual threads to complete their execution.
        // The 'join()' method blocks the main thread until the virtual thread finishes.
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        long endTimeDirect = System.currentTimeMillis();
        logger.info("Method 1: All " + numberOfVirtualThreads + " virtual threads completed in " + (endTimeDirect - startTimeDirect) + " ms.");


        // --- Method 2: Using Executors.newVirtualThreadPerTaskExecutor() (Recommended) ---
        // This is generally the preferred way when you have a collection of tasks to run concurrently,
        // as it leverages the ExecutorService framework for easier management.
        logger.info("\n--- Method 2: Virtual Threads via ExecutorService ---");
        long startTimeExecutor = System.currentTimeMillis();

        // Executors.newVirtualThreadPerTaskExecutor() creates an ExecutorService
        // where each submitted task runs on a new virtual thread.
        // The try-with-resources statement ensures that the executor is properly closed
        // (which for this type of executor means waiting for all submitted tasks to complete).
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            List<Future<?>> futures = new ArrayList<>();
            for (int i = 0; i < numberOfVirtualThreads; i++) {
                // Create a new instance of ThreadTesting for each task submitted to the executor.
                ThreadTesting task = new ThreadTesting();
                // Submit the Runnable task to the executor.
                // The executor will create a new virtual thread for this task and run it.
                futures.add(executor.submit(task));
            }

            // Optionally, wait for all tasks submitted to the executor to complete.
            // The 'try-with-resources' block for the executor handles this implicitly on close,
            // but if you needed to explicitly wait for individual tasks or check their status,
            // you would iterate through 'futures' and call 'future.get()'.
            // For this example, the implicit waiting of the try-with-resources is sufficient.
            for (Future<?> future : futures) {
                future.get(); // Blocks until the task completes
            }

        } catch (Exception e) {
            logger.error("An error occurred with the ExecutorService: " + e.getMessage());
            e.printStackTrace();
        }
        long endTimeExecutor = System.currentTimeMillis();
        logger.info("Method 2: All " + numberOfVirtualThreads + " virtual threads (Executor) completed in " + (endTimeExecutor - startTimeExecutor) + " ms.");

        logger.info("Xmx: " + Runtime.getRuntime().maxMemory() / (1024 * 1024) + " MB");
        logger.info("current memory: " + Runtime.getRuntime().totalMemory() / (1024 * 1024) + " MB");
        logger.info("free memory: " + Runtime.getRuntime().freeMemory() / (1024 * 1024) + " MB");

        HashMapWithSizeCheck hashMapWithSizeCheck1 = new HashMapWithSizeCheck("Koyla", "Kali");
        HashMapWithSizeCheck hashMapWithSizeCheck2 = new HashMapWithSizeCheck("Koyla", "Kali");
        HashMapWithSizeCheck hashMapWithSizeCheck3 = new HashMapWithSizeCheck("Koyla", "Kali");

        HashMap<String, String> hashMap1 = new HashMap<>();
        hashMap1.put(hashMapWithSizeCheck1.getFirstName(), hashMapWithSizeCheck1.getLastName());
        hashMap1.put(hashMapWithSizeCheck2.getFirstName(), hashMapWithSizeCheck2.getLastName());
        hashMap1.put(hashMapWithSizeCheck3.getFirstName(), hashMapWithSizeCheck3.getLastName());

        logger.info("Size of HashMap<String, String> with default PoJo is :"+ hashMap1.size());
        //        Size is 1 as key is same Koyla hence its replaced

        HashMapWithSizeCheck hashMapWithSizeCheck4 = new HashMapWithSizeCheck("Koyla1", "Kali1");
        HashMapWithSizeCheck hashMapWithSizeCheck5 = new HashMapWithSizeCheck("Koyla1", "Kali1");
        HashMapWithSizeCheck hashMapWithSizeCheck6 = new HashMapWithSizeCheck("Koyla2", "Kali2");

        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put(hashMapWithSizeCheck4.getFirstName(), hashMapWithSizeCheck4.getLastName());
        hashMap2.put(hashMapWithSizeCheck5.getFirstName(), hashMapWithSizeCheck5.getLastName());
        hashMap2.put(hashMapWithSizeCheck6.getFirstName(), hashMapWithSizeCheck6.getLastName());

        logger.info("Size of HashMap<String, String> with default PoJo is :"+ hashMap2.size());
        //        Size is 2 as key is same Koyla1 hence its replaced

        logger.info("hashCode of hashMapWithSizeCheck4 "+ hashMapWithSizeCheck4.hashCode() +" hashMapWithSizeCheck5 "+hashMapWithSizeCheck5.hashCode());
        logger.info("equals of hashMapWithSizeCheck4 and hashMapWithSizeCheck5 "+hashMapWithSizeCheck4.equals(hashMapWithSizeCheck5));
//        logger.info("= of hashMapWithSizeCheck4 and hashMapWithSizeCheck5 "+hashMapWithSizeCheck4 == hashMapWithSizeCheck5);
        logger.info("hashCode of hashMapWithSizeCheck4.FirstName "+ hashMapWithSizeCheck4.getFirstName().hashCode() +" hashMapWithSizeCheck5.FirstName "+hashMapWithSizeCheck5.getFirstName().hashCode());
        logger.info("equals of hashMapWithSizeCheck4.FirstName and hashMapWithSizeCheck5.FirstName "+hashMapWithSizeCheck4.getFirstName().equals(hashMapWithSizeCheck5.getFirstName()));


        HashMap<HashMapWithSizeCheck, String> hashMap3 = new HashMap<>();

        hashMap3.put(hashMapWithSizeCheck1, hashMapWithSizeCheck1.getFirstName());
        hashMap3.put(hashMapWithSizeCheck2, hashMapWithSizeCheck2.getFirstName());
        hashMap3.put(hashMapWithSizeCheck3, hashMapWithSizeCheck3.getFirstName());

        logger.info("Size of HashMap<HashMapWithSizeCheck, String> with default PoJo is :"+ hashMap3.size());


        HashMap<HashMapWithSizeCheckCustomHashCode, String> hashMap4 = new HashMap<>();

        HashMapWithSizeCheckCustomHashCode hashMapWithSizeCheckCustomHashCode1 = new HashMapWithSizeCheckCustomHashCode("Koyla", "Kali");
        HashMapWithSizeCheckCustomHashCode hashMapWithSizeCheckCustomHashCode2 = new HashMapWithSizeCheckCustomHashCode("Koyla", "Kali");

        hashMap4.put(hashMapWithSizeCheckCustomHashCode1, hashMapWithSizeCheckCustomHashCode1.getFirstName());
        hashMap4.put(hashMapWithSizeCheckCustomHashCode2, hashMapWithSizeCheckCustomHashCode2.getFirstName());

        logger.info("Size of HashMap<HashMapWithSizeCheckCustomHashCode, String> is :"+ hashMap4.size());


        HashMapWithSizeCheckCustomHashCode hashMapWithSizeCheckCustomHashCode3 = new HashMapWithSizeCheckCustomHashCode("Koyla", "Kali");
        HashMapWithSizeCheckCustomHashCode hashMapWithSizeCheckCustomHashCode4 = new HashMapWithSizeCheckCustomHashCode("Koyla", "Kali1");

        hashMap4.put(hashMapWithSizeCheckCustomHashCode3, hashMapWithSizeCheckCustomHashCode3.getFirstName());
        hashMap4.put(hashMapWithSizeCheckCustomHashCode4, hashMapWithSizeCheckCustomHashCode4.getFirstName());

        logger.info("Size of HashMap<HashMapWithSizeCheckCustomHashCode, String> is :"+ hashMap4.size());


        logger.info("Xmx: " + Runtime.getRuntime().maxMemory() / (1024 * 1024) + " MB");
        logger.info("current memory: " + Runtime.getRuntime().totalMemory() / (1024 * 1024) + " MB");
        logger.info("free memory: " + Runtime.getRuntime().freeMemory() / (1024 * 1024) + " MB");


        LinkedList<String> stringLinkedList1 = new LinkedList<>();

        RandomUtil randomUtil = new RandomUtil();

        for (int i = 0; i < 1165608; i++) {
            stringLinkedList1.add(randomUtil.randomString(50, 75));
        }

        logger.info("Elemets in List are "+stringLinkedList1.size());

        logger.info("Xmx: " + Runtime.getRuntime().maxMemory() / (1024 * 1024) + " MB");
        logger.info("current memory: " + Runtime.getRuntime().totalMemory() / (1024 * 1024) + " MB");
        logger.info("free memory: " + Runtime.getRuntime().freeMemory() / (1024 * 1024) + " MB");

        stringLinkedList1 = null;
        stringLinkedList1 = randomUtil.generateParallelRandomStrings(1165608, 50, 75);

        logger.info("Elemets in List are "+stringLinkedList1.size());

        logger.info("Xmx: " + Runtime.getRuntime().maxMemory() / (1024 * 1024) + " MB");
        logger.info("current memory: " + Runtime.getRuntime().totalMemory() / (1024 * 1024) + " MB");
        logger.info("free memory: " + Runtime.getRuntime().freeMemory() / (1024 * 1024) + " MB");

        logger.info("\nApplication finished.");
    }
}
