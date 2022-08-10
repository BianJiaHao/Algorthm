package com.bianjiahao.algorithm.class01;

public class ReverseSinglyLinkedList {

    public static class Node {
        private int value;
        private Node next;
        private Node last;
    }

    public static Node reverseDoubleLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }




}
