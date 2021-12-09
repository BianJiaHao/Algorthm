package com.bianjiahao.algorithm.class08;

/**
 * 是否是完全二叉树
 * @author BianJiaHao
 */
public class IsCBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class Info {
        public boolean isCbt;
        public boolean isFull;
        public int height;

        public Info(boolean isCbt, boolean isFull, int height) {
            this.isCbt = isCbt;
            this.isFull = isFull;
            this.height = height;
        }
    }

    public static boolean isCBT(Node head) {
        return getIsCBT(head).isCbt;
    }

    public static Info getIsCBT(Node head) {
        if (head == null){
            return new Info(true,true,0);
        }
        Info leftInfo = getIsCBT(head.left);
        Info rightInfo = getIsCBT(head.right);
        boolean isFull = leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height;
        int height = Math.max(leftInfo.height,rightInfo.height) + 1;
        boolean isCBT = false;
        if (isFull){
            isCBT = true;
        }else {
            if (leftInfo.isCbt && rightInfo.isFull && leftInfo.height - 1 == rightInfo.height){
                isCBT = true;
            }
            if (leftInfo.isFull && rightInfo.isFull && leftInfo.height - 1 == rightInfo.height){
                isCBT = true;
            }
            if (leftInfo.isFull && rightInfo.isCbt && leftInfo.height == rightInfo.height){
                isCBT = true;
            }
        }
        return new Info(isCBT,isFull,height);
    }
}
