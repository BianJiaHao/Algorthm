package com.bianjiahao.algorithm.class07;

import java.util.Stack;

/**
 * 非递归实现二叉树遍历
 * @author BianJiaHao
 */
public class UnRecursiveTraversalBT {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }

    public static void pre(Node head){
        if (head != null){
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                System.out.println(head.value);
                if (head.right != null){
                    stack.push(head.right);
                }
                if (head.left != null){
                    stack.push(head.left);
                }
            }
        }
    }

    public static void in(Node head){
        if (head != null){
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null){
                if (head != null){
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

    public static void pos1(Node head){
        if (head != null){
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.add(head);
            while (!stack1.isEmpty()){
                head = stack1.pop();
                stack2.push(head);
                if (head.right != null){
                    stack1.push(head.right);
                }
                if (head.left != null){
                    stack1.push(head.left);
                }
            }
            while (!stack2.isEmpty()) {
                System.out.print(stack2.pop().value + " ");
            }
        }
    }

    public static void pos2(Node head){
        if (head != null){
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            Node cur = null;
            while (!stack.isEmpty()){
                 cur = stack.peek();
                 if (cur.left != null && head != cur.left && head != cur.right){
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
