package org.example.dsa.collection.stack;

import java.util.logging.Logger;

public class StackUsingArray {
    private int arr[];
    private int capacity;
    private int top;

    private Logger logger =  Logger.getLogger(StackUsingArray.class.getName());

    public StackUsingArray(int capacity)
    {
        this.capacity = capacity;
        arr = new int[capacity];
        top = -1;
    }

//    push operation
    public void push(int val) {
        if (top == capacity-1) {
            logger.info("Stack overflow");
            return;
        }
        arr[++top] = val;
    }

//    pop operation
    public int pop() {
        if (top == -1) {
            logger.info("Stack underflow");
            return -1;
        }
        return arr[top--];
    }

//    peek operation
    public int peek() {
        if (top == -1) {
            logger.info("Stack underflow");
            return -1;
        }
        return arr[top];
    }

//    isEmpty
    public boolean isEmpty() {
        return top == -1;
    }

//    size
    public boolean isFull() {
        return top == capacity - 1;
    }

    public void printStack() {
        if (top == -1) {
            logger.info("Stack underflow");
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }
}
