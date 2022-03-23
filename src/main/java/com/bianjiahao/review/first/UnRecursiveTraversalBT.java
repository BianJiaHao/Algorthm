package com.bianjiahao.review.first;

import java.util.Stack;

/**
 * @author admin
 */
public class UnRecursiveTraversalBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void prePrint(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.value);
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
    }

    public static void inPrint(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    System.out.println(head.value);
                    head = head.right;
                }
            }
        }
    }

    public static void posPrint(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            Node cur;
            while (!stack.isEmpty()) {
                cur = stack.peek();
                if (cur.left != null && head != cur.left && head != cur.right) {
                    stack.push(cur.left);
                }else if (cur.right != null && head != cur.right){
                    stack.push(cur.right);
                }else {
                    System.out.println(stack.pop().value);
                    head = cur;
                }
            }
        }
    }
}
