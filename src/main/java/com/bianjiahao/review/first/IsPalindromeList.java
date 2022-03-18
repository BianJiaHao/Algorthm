package com.bianjiahao.review.first;

import java.util.Stack;

/**
 * @author admin
 */
public class IsPalindromeList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isPalindromeListUseStack(Node head) {
        if (head == null) {
            return false;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.isEmpty()) {
            if (stack.pop().value != head.value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindromeListUseStackAndMidPoint(Node head) {
        if (head == null) {
            return false;
        }
        Node slow = head.next;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Stack<Node> stack = new Stack<>();
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }
        while (!stack.isEmpty()) {
            if (stack.pop().value != head.value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindromeListOptimalSolution(Node head) {
        if (head == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        Node help;
        while (fast != null){
            help = fast.next;
            fast.next = slow;
            slow = fast;
            fast = help;
        }
        help = slow;
        fast = head;
        boolean res = true;
        while (slow != null && fast != null){
            if (slow.value != fast.value){
                res = false;
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        slow = help.next;
        help.next = null;
        while (slow != null){
            fast = slow.next;
            slow.next = help;
            help = slow;
            slow = fast;
        }
        return res;

    }
}
