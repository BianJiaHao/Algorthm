package com.bianjiahao.algorithm.class08;

/**
 * 最大二叉搜索子树的头结点
 * @author BianJiaHao
 */
public class MaxSubBtHead {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class Info {
        public Node maxSubBsHead;
        public int maxSubBsSize;
        public int min;
        public int max;

        public Info(Node maxSubBsHead, int maxSubBsSize, int min, int max) {
            this.maxSubBsHead = maxSubBsHead;
            this.maxSubBsSize = maxSubBsSize;
            this.min = min;
            this.max = max;
        }
    }

    public static Node maxSubBsHead(Node head) {
        return getMaxSubBsHead(head).maxSubBsHead;
    }

    public static Info getMaxSubBsHead(Node head) {
        if (head == null){
            return null;
        }
        Info leftInfo = getMaxSubBsHead(head.left);
        Info rightInfo = getMaxSubBsHead(head.right);
        int min = head.value;
        int max = head.value;
        Node maxSubBsHead = null;
        int maxSubBsSize = 0;
        if (leftInfo != null){
            min = Math.min(min,leftInfo.min);
            max = Math.max(max,leftInfo.max);
            maxSubBsHead = leftInfo.maxSubBsHead;
            maxSubBsSize = leftInfo.maxSubBsSize;
        }
        if (rightInfo != null){
            min = Math.min(min,rightInfo.min);
            max = Math.max(max,rightInfo.max);
            if (rightInfo.maxSubBsSize > maxSubBsSize){
                maxSubBsHead = rightInfo.maxSubBsHead;
                maxSubBsSize = rightInfo.maxSubBsSize;
            }
        }
        if ((leftInfo == null ? true : (leftInfo.maxSubBsHead == head.left && leftInfo.max < head.value))
                && (rightInfo == null ? true : (rightInfo.maxSubBsHead == head.right && rightInfo.min > head.value))){
            maxSubBsHead = head;
            maxSubBsSize = (leftInfo == null ? 0 : leftInfo.maxSubBsSize) + (rightInfo == null ? 0 : rightInfo.maxSubBsSize) + 1;
        }
        return new Info(maxSubBsHead,maxSubBsSize,min,max);
    }
}
