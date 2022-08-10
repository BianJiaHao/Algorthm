package com.bianjiahao.algorithm.class01;

public class ReverseKGroupLinkedList {

    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            next = null;
        }
    }

    public static Node getGroupEndNode(Node start,int k) {
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }

    public static void reverse(Node start,Node end) {
        // 记录这个组最后一个节点的后序节点，反转之后start节点要连接上这个后序节点
        end = end.next;
        // 用另外的变量表示start，反转后要将start节点连接上后序节点
        Node cur = start;
        Node pre = null;
        Node next = null;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }

    public static Node reverseKGroupLinkedList(Node head,int k) {
        Node start = head;
        Node end = getGroupEndNode(start,k);
        if (end == null) {
            return head;
        }
        head = end;
        reverse(start,end);
        // 下一组反转完后要将前面一组最后的节点连接上这一组的start
        Node lastEnd = start.next;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = getGroupEndNode(start,k);
            if (end == null) {
                return head;
            }
            reverse(start,end);
            lastEnd.next = start;
            lastEnd = end;
        }


        return head;
    }
}
