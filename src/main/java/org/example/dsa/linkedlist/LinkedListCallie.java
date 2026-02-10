package org.example.dsa.linkedlist;

public class LinkedListCallie {
    public static void singlyLinkedList() {
        // LinkedlIst
        LinkedListNode linkedListNode = new LinkedListNode("what");
//        LinkedListNode linkedListNode1 = linkedListNode;
//        linkedListNode.addFirst("is", linkedListNode1);
//        linkedListNode.addFirst("This", linkedListNode1);
//        linkedListNode.addLast("it", linkedListNode1);
//        linkedListNode.addLast("is", linkedListNode1);
//
//        linkedListNode.print(linkedListNode1);

        linkedListNode.next = new LinkedListNode("what");
        linkedListNode.next.next = new LinkedListNode("is");
        linkedListNode.next.next.next = new LinkedListNode("it");
        linkedListNode.next.next.next.next = new LinkedListNode("that");
        linkedListNode.next.next.next.next.next = new LinkedListNode("you");
        linkedListNode.next.next.next.next.next.next = new LinkedListNode("want");

        LinkedListNode tempHead = linkedListNode;

        System.out.println("Add : ");
        while (tempHead != null) {
            System.out.print(tempHead.data + " ");
            tempHead = tempHead.next;
        }
        System.out.println();


        tempHead = linkedListNode;
        LinkedListNode insertAtBegining = new LinkedListNode("what");
        insertAtBegining.next = tempHead;
        tempHead = insertAtBegining;

        System.out.println("InsertAtBegining : ");
        while (tempHead != null) {
            System.out.print(tempHead.data + " ");
            tempHead = tempHead.next;
        }
        System.out.println();

        tempHead = linkedListNode;
        LinkedListNode insertAtEnd = new LinkedListNode("tell");
        while (tempHead.next != null) {
            tempHead = tempHead.next;
        }

        tempHead.next = insertAtEnd;
        tempHead = linkedListNode;

        System.out.println("InsertAtEnd : ");
        while (tempHead != null) {
            System.out.print(tempHead.data + " ");
            tempHead = tempHead.next;
        }
        System.out.println();

        tempHead = linkedListNode;
        LinkedListNode tempHead2 = null;
        int pos = 3;
        while (tempHead != null) {
            if (pos == 1) {
                tempHead2 = tempHead;
            }
            if (pos == 0) {
                break;
            }
            tempHead = tempHead.next;
            pos--;
        }

        LinkedListNode atSpecificPos = new LinkedListNode("inBetween");
        tempHead2.next = atSpecificPos;
        atSpecificPos.next = tempHead;

        tempHead2 = null;
        tempHead = linkedListNode;

        System.out.println("InsertInBetween : ");
        while (tempHead != null) {
            System.out.print(tempHead.data + " ");
            tempHead = tempHead.next;
        }
        System.out.println();

        // Delete from linkedlist
//        Delete at start is pos=1
        pos = 1;

        tempHead = linkedListNode;
        tempHead = linkedListNode.next;

        System.out.println("Delete First : ");
        while (tempHead != null) {
            System.out.print(tempHead.data + " ");
            tempHead = tempHead.next;
        }
        System.out.println();

        pos = 4;
        int count = 0;

        tempHead = linkedListNode;
        tempHead2 = tempHead;

        while (tempHead != null) {
            count++;
            if (count == pos) {
                tempHead2.next = tempHead.next;
                break;
            }
            if (count > 1) {
                tempHead2 = tempHead2.next;
            }
            tempHead = tempHead.next;
        }

        tempHead = linkedListNode;
        tempHead2 = null;

        System.out.println("Delete InBetween : ");
        while (tempHead != null) {
            System.out.print(tempHead.data + " ");
            tempHead = tempHead.next;
        }
        System.out.println();

//        tempHead = linkedListNode;
//        tempHead2 = null;
//
//        count = 0;
//        while (tempHead.next != null) {
//            count++;
//            tempHead =  tempHead.next;
//        }

        pos = 0;

        tempHead = linkedListNode;
        tempHead2 = tempHead;

        while (tempHead.next != null) {
            pos++;
            if (pos > 1) {
                tempHead2 = tempHead2.next;
            }
            tempHead = tempHead.next;
        }

        tempHead2.next = null;

        tempHead = linkedListNode;
        tempHead2 = tempHead;

        System.out.println("Delete Last : ");
        while (tempHead != null) {
            System.out.print(tempHead.data + " ");
            tempHead = tempHead.next;
        }
        System.out.println();
    }
}
