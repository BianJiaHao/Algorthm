package com.bianjiahao.review.first;

import org.w3c.dom.Node;

/**
 * 输入链表头节点，奇数长度返回中点，偶数长度返回上中点
 * 输入链表头节点，奇数长度返回中点，偶数长度返回下中点
 * 输入链表头节点，奇数长度返回中点前一个，偶数长度返回上中点前一个
 * 输入链表头节点，奇数长度返回中点前一个，偶数长度返回下中点前一个
 */
public class LinkedListMid {

    public static class Node {
        public int value;
        public Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    // 输入链表头节点，奇数长度返回中点，偶数长度返回上中点
    public static Node midOrUpNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (slow.next != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 输入链表头节点，奇数长度返回中点，偶数长度返回下中点
    public static Node midOrDownNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head.next;
        Node fast = head.next;
        while (slow.next !=null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 输入链表头节点，奇数长度返回中点前一个，偶数长度返回上中点前一个
    public static Node midOrUpPreNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head.next.next;
        while (slow.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 输入链表头节点，奇数长度返回中点前一个，偶数长度返回下中点前一个
    public static Node midOrDownPreNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head.next;
        while (slow.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}
