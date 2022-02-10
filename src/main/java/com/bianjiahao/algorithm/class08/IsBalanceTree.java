package com.bianjiahao.algorithm.class08;

/**
 * 判断一个二叉树是否是平衡二叉树
 * @author BianJiaHao
 */
public class IsBalanceTree {

    public static class TreeNode {

        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static class Info {
        Boolean isBalance;
        int maxHeight;

        public Info(Boolean isBalance, int maxHeight) {
            this.isBalance = isBalance;
            this.maxHeight = maxHeight;
        }
    }

    public static Info isBalanceTreeMethod(TreeNode head){
        if (head == null){
            return new Info(true,0);
        }

        Info leftInfo = isBalanceTreeMethod(head.left);
        Info rightInfo = isBalanceTreeMethod(head.right);
        int height = Math.max(leftInfo.maxHeight,rightInfo.maxHeight) + 1;
        boolean isBalance = leftInfo.isBalance && rightInfo.isBalance && Math.abs(leftInfo.maxHeight - rightInfo.maxHeight) <= 1;
        return new Info(isBalance,height);
    }

    public static boolean isBalance(TreeNode head){
        return isBalanceTreeMethod(head).isBalance;
    }

}
