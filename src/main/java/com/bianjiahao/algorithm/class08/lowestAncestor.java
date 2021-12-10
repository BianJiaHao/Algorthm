package com.bianjiahao.algorithm.class08;

/**
 * 两个节点的公共祖先
 * @author BianJiaHao
 */
public class lowestAncestor {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class Info {
        public Node ans;
        public boolean findO1;
        public boolean findO2;

        public Info(Node ans, boolean findO1, boolean findO2) {
            this.ans = ans;
            this.findO1 = findO1;
            this.findO2 = findO2;
        }
    }

    public static Node lowestAncestor(Node head,Node o1,Node o2){
        return getLowestAncestor(head,o1,o2).ans;
    }

    public static Info getLowestAncestor(Node head,Node o1,Node o2){
        if (head == null){
            return new Info(null,false,false);
        }
        Info leftInfo = getLowestAncestor(head.left, o1, o2);
        Info rightInfo = getLowestAncestor(head.right, o1, o2);
        Node ans = null;
        boolean findO1 = head == o1 || leftInfo.findO1 || rightInfo.findO1;
        boolean findO2 = head == o2 || leftInfo.findO2 || rightInfo.findO2;
        if (leftInfo.ans != null){
            ans = leftInfo.ans;
        }
        if (rightInfo.ans != null){
            ans = rightInfo.ans;
        }
        if (ans == null){
            if (findO1 && findO2){
                ans = head;
            }
        }
        return new Info(ans,findO1,findO2);
    }
}
