package com.bianjiahao.algorithm.class08;

/**
 * 以X为头节点的二叉树是否是搜索二叉树
 * @author BianJiaHao
 */
public class isBSTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    public static Boolean isBsTree(Node head){
        if (head == null){
            return true;
        }
        return isBsTreeMethod(head).isBsTree;
    }

    public static class Info {
        boolean isBsTree;
        int max;
        int min;

        public Info(boolean isBsTree, int max, int min) {
            this.isBsTree = isBsTree;
            this.max = max;
            this.min = min;
        }
    }

    public static Info isBsTreeMethod(Node head){
        if (head == null){
            return null;
        }
        int max = head.value;
        int min = head.value;
        Info leftInfo = isBsTreeMethod(head.left);
        Info rightInfo = isBsTreeMethod(head.right);
        if (leftInfo != null){
            max = Math.max(max,leftInfo.max);
            min = Math.min(min,leftInfo.min);
        }
        if (rightInfo != null){
            max = Math.max(max,rightInfo.max);
            min = Math.min(min,rightInfo.min);
        }
        boolean isBsTree = false;
        if ((leftInfo == null ? true : (leftInfo.isBsTree && leftInfo.max < head.value)) && (rightInfo == null ? true : (rightInfo.isBsTree && rightInfo.min > head.value))){
            isBsTree = true;
        }
        return new Info(isBsTree,max,min);
    }
}
