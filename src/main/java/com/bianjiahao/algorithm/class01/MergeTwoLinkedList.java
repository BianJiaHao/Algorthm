package com.bianjiahao.algorithm.class01;

public class MergeTwoLinkedList {

    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static Node mergeTwoLinkedList(Node head1,Node head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }

        Node head = head1.value <= head2.value ? head1 : head2;
        Node curS = head.next;
        Node curL = head == head1 ? head2 : head1;
        Node pre = head;
        while (curS != null && curL != null) {
            if (curS.value <= curL.value) {
                pre.next = curS;
                curS = curS.next;
            }else {
                pre.next = curL;
                curL = curL.next;
            }
            pre = pre.next;
        }

        pre.next = curL == null ? curS : curL;

        return head;
    }
}
