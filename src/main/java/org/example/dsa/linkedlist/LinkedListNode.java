package org.example.dsa.linkedlist;


import java.util.LinkedList;

public class LinkedListNode {
    public String data;
    public LinkedListNode next;

    public LinkedListNode(String data) {
        this.data = data;
        this.next = null;
    }

//    public void addFirst(String data, LinkedListNode head){
//        LinkedListNode newNode = new LinkedListNode(data);
//        if (head == null) {
//            head = newNode;
//            return;
//        }
//        newNode.next = head;
//        head = newNode;
//    }
//
//    public void addLast(String data, LinkedListNode head){
//        LinkedListNode newNode = new LinkedListNode(data);
//        LinkedListNode tempHead = head;
//        if (tempHead == null) {
//            tempHead = newNode;
//        }
//        while (tempHead.next != null) {
//            tempHead = tempHead.next;
//        }
//        tempHead.next = newNode;
//    }
//
//    public void print(LinkedListNode head) {
//        while (head != null) {
//            System.out.print(head.data + " ");
//            head = head.next;
//        }
//    }
}
