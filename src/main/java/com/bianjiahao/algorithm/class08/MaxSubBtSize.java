package com.bianjiahao.algorithm.class08;

/**
 * 最大搜索二叉树大小
 * @author BianJiaHao
 */
public class MaxSubBtSize {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class Info {
        boolean isBsTree;
        int maxSubBtSize;
        int min;
        int max;

        public Info(boolean isBsTree, int maxSubBtSize, int min, int max) {
            this.isBsTree = isBsTree;
            this.maxSubBtSize = maxSubBtSize;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxSubBtSize(Node head) {
        return getMaxSubBtSize(head).maxSubBtSize;
    }

    public static Info getMaxSubBtSize(Node head) {
        if (head == null){
            return null;
        }
        Info leftInfo = getMaxSubBtSize(head.left);
        Info rightInfo = getMaxSubBtSize(head.right);
        int maxSubBsTree = 0;
        int min = head.value;
        int max = head.value;
        if (leftInfo != null){
            min = Math.min(min,leftInfo.min);
            max = Math.max(max,leftInfo.max);
            maxSubBsTree = Math.max(maxSubBsTree,leftInfo.maxSubBtSize);
        }
        if (rightInfo != null){
            min = Math.min(min,rightInfo.min);
            max = Math.max(max,rightInfo.max);
            maxSubBsTree = Math.max(maxSubBsTree,rightInfo.maxSubBtSize);
        }
        boolean isBsTree = false;
        if (leftInfo == null ? true : (leftInfo.isBsTree && leftInfo.max < head.value) && (rightInfo == null ? true : (rightInfo.isBsTree && rightInfo.min > head.value))){
            isBsTree = true;
            maxSubBsTree = (leftInfo == null ? 0 : leftInfo.maxSubBtSize) + (rightInfo == null ? 0 : rightInfo.maxSubBtSize) + 1;
        }
        return new Info(isBsTree,maxSubBsTree,min,max);
    }
}
