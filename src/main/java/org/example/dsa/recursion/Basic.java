package org.example.dsa.recursion;

public class Basic {
    public void recursion(int n) {
        if (n >= 5) {
            return;
        }
        else {
            System.out.println(n);
            recursion(n + 1);
        }
    }

    public void printNumbers(int n) {
        // Your code goes here
        if (n <= 0) {
            return;
        }
        printNumbers(n-1);
        System.out.println(n);
    }
}
