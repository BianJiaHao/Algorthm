package com.bianjiahao.algorithm.class06;

/**
 * 找到两个有环或者无环链表第一次相交的节点
 * @author BianJiaHao
 */
public class FindFirstIntersectNode {

    public static class Node {

        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 找到单链表的第一个入环的节点
     * @param head 头结点
     * @return 第一个入环的节点
     */
    public static Node getLoopNode(Node head) {

        if (head == null || head.next == null || head.next.next == null){
            return null;
        }

        Node slow = head.next;
        Node faster = head.next.next;

        while (slow != faster){
            if (faster.next == null || faster.next.next == null){
                return null;
            }
            slow = slow.next;
            faster = faster.next.next;
        }

        faster = head;
        while (slow != faster){
            slow = slow.next;
            faster = faster.next;
        }

        return slow;
    }

    /**
     * 假如两个链表都有环，如果两个链表相交，返回第一个相交的节点，如果不相交返回null
     * @param head1 第一个链表的头结点
     * @param head2 第二个链表的头结点
     * @return 第一个相交的节点
     */
    public static Node noLoop(Node head1,Node head2) {

        if (head1 == null || head2 == null){
            return null;
        }

        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;

        while (cur1.next != null){
            n++;
            cur1 = cur1.next;
        }

        while (cur2.next != null){
            n--;
            cur2 = cur2.next;
        }

        if (cur1 != cur2){
            return null;
        }

        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n != 0){
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    /**
     * 两个有环的单链表如果相交，返回第一个相交的节点，否则返回null
     * @param head1 第一个链表的头结点
     * @param loop1 第一个链表的入环节点
     * @param head2 第二个链表的头结点
     * @param loop2 第二个链表的入环节点
     * @return 两个链表第一个相交节点
     */
    public static Node bothLoop(Node head1,Node loop1,Node head2,Node loop2){
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2){
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1){
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2){
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0){
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else {
            cur1 = loop1.next;
            while (cur1 != loop1){
                if (cur1 == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }
}
