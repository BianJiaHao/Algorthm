package com.bianjiahao.algorithm.class07;

/**
 * 递归遍历二叉树
 * @author BianJiaHao
 */
public class RecursiveTraversalBT {

    public static class Node{

        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }

    public static void pre(Node head){
        if (head == null){
            return;
        }
        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }

    public static void in(Node head){
        if (head == null){
            return;
        }
        in(head.left);
        System.out.println(head.value);
        in(head.right);
    }

    public static void pos(Node head){
        if (head == null){
            return;
        }
        pos(head.left);
        pos(head.right);
        System.out.println(head.value);
    }

}
