package com.bianjiahao.algorithm.class08;

/**
 * 二叉树的最大距离
 * @author BianJiaHao
 */
public class MaxDistance {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class Info {
        int maxDistance;
        int height;

        public Info(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }

    public static int maxDistance(Node head) {
        return getMaxDistance(head).maxDistance;
    }

    public static Info getMaxDistance(Node head) {
        if (head == null){
            return new Info(0,0);
        }

        Info leftInfo = getMaxDistance(head.left);
        Info rightInfo = getMaxDistance(head.right);

        int maxDistance = Math.max(Math.max(rightInfo.maxDistance,leftInfo.maxDistance),(leftInfo.height + rightInfo.height + 1));
        int height = Math.max(leftInfo.height,rightInfo.height) + 1;

        return new Info(maxDistance,height);
    }

}
