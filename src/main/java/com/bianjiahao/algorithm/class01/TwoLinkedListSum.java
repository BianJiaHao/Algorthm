package com.bianjiahao.algorithm.class01;

public class TwoLinkedListSum {

    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    /**
     * 求链表长度
     * @param head 链表的头结点
     * @return 链表的长度
     */
    public static int getLinkedListLength(Node head) {
        int ans = 0;
        while (head.next != null) {
            ans++;
            head = head.next;
        }
        return ans;
    }

    public static Node getTwoLinkedListSum(Node head1,Node head2) {
        int lengthOfOne = getLinkedListLength(head1);
        int lengthOfTwo = getLinkedListLength(head2);
        Node l = lengthOfOne > lengthOfTwo ? head1 : head2;
        Node s = l == head1 ? head2 : head1;
        Node curL = l;
        Node curS = s;
        // 永远追随长链表，如果最后还有进为需要补一个1
        Node last = curL;
        int carry = 0;
        int curNum = 0;
        // 第一阶段，两个链表都还有节点
        while (curS != null) {
            curNum = curL.value + curS.value + carry;
            curL.value = curNum % 10;
            carry = curNum / 10;
            last = curL;
            curL = curL.next;
            curS = curS.next;
        }
        // 第二阶段，只有长链表还有节点
        while (curL != null) {
            curNum = curL.value + carry;
            curL.value = curNum % 10;
            carry = curNum / 10;
            last = curL;
            curL = curL.next;
        }
        // 第三阶段，两个链表都没有节点
        if (carry != 0) {
            last.next = new Node(1);
        }
        return l;
    }
}
