package com.bianjiahao.review.first;

/**
 * @author Obito
 */
public class RecursiveTraversalBT {

    public static class Node {
        // 节点值
        public int value;
        // 左孩子
        public Node left;
        // 右孩子
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void f(Node head) {
        if (head == null) {
            return;
        }
        // 1
        f(head.left);
        // 2
        f(head.right);
        // 3
    }

    /**
     * 先序打印
     * @param head 二叉树头结点
     */
    public static void prePrint(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        prePrint(head.left);
        prePrint(head.right);
    }

    /**
     * 中序打印
     * @param head 二叉树的头结点
     */
    public static void inPrint(Node head) {
        if (head == null) {
            return;
        }
        inPrint(head.left);
        System.out.println(head.value);
        inPrint(head.right);
    }

    /**
     * 二叉树的后序打印
     * @param head 二叉树的头结点
     */
    public static void posPrint(Node head) {
        if (head == null) {
            return;
        }
        posPrint(head.left);
        posPrint(head.right);
        System.out.println(head.value);
    }

}
