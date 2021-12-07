package com.bianjiahao.algorithm.class08;

/**
 * 以x为头的二叉树是否是满二叉树
 * @author BianJiaHao
 */
public class IsFull {

    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    public static Boolean isFullTree(Node head){
        if (head == null){
            return true;
        }
        Info treeInfo = isFull(head);
        return (1 << treeInfo.height) == treeInfo.nodesSize;
    }

    public static class Info {
        int height;
        int nodesSize;
        public Info(int height, int nodesSize) {
            this.height = height;
            this.nodesSize = nodesSize;
        }
    }

    public static Info isFull(Node head) {
        if (head == null){
            return new Info(0,0);
        }
        Info leftInfo = isFull(head.left);
        Info rightInfo = isFull(head.right);
        int height = Math.max(leftInfo.height,rightInfo.height) + 1;
        int nodeSize = leftInfo.nodesSize + rightInfo.nodesSize + 1;
        return new Info(height,nodeSize);
    }
}
