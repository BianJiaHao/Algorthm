package com.bianjiahao.leetCode;

/**
 * 两数相加
 * @author Obito
 */
public class Topic02SumOfTwoNumber {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1,ListNode l2) {
        if (l1 == null || l2 == null){
            return null;
        }
        ListNode firstNode = l1;
        ListNode secondNode = l2;
        ListNode ans = new ListNode(0);
        ListNode ansIndex = ans;
        while (firstNode != null || secondNode != null){
            int firstVal = firstNode == null ? 0 : firstNode.val;
            int secondVal = secondNode == null ? 0 : secondNode.val;
            if (firstVal + secondVal >= 10){
                ans.val = ans.val + (firstVal + secondVal) % 10;
                ans.next = new ListNode(1);
            }else {
                if (firstVal + secondVal + ans.val >= 10){
                    ans.val = (firstVal + secondVal + ans.val) % 10;
                    ans.next = new ListNode(1);
                }else {
                    ans.val = ans.val + firstVal + secondVal;
                    if (firstNode != null && firstNode.next != null || secondNode != null && secondNode.next != null){
                        ans.next = new ListNode(0);
                    }
                }
            }
            firstNode = firstNode != null && firstNode.next != null ? firstNode.next : null;
            secondNode = secondNode != null && secondNode.next != null ? secondNode.next : null;
            ans = ans.next;
        }
        return ansIndex;

    }

    public static void main(String[] args) {
        System.out.println(18%10);
    }
}
