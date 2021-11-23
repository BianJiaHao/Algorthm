package com.bianjiahao.algorithm.class06;

import java.util.ArrayList;

/**
 * 链表的近似中点问题
 * @author BianJiaHao
 */
public class LinkedListMid {
    // 创建一个链表节点类
    public static class Node{
        public int value;
        public Node next;
        public Node(int v){
            value = v;
        }
    }

    // 输入链表头节点，奇数长度返回中点，偶数长度返回上中点
    public static Node midOrUpNode(Node node){
        // 如果这个链表只有一个或者两个或者一个都没有直接返回头结点
        if (node == null || node.next == null || node.next.next == null){
            return node;
        }
        Node slow = node.next;
        Node fast = node.next.next;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 输入链表头节点，奇数长度返回中点，偶数长度返回下中点
    public static Node midOrDownNode(Node node){
        // 只有当链表中只有一个头节点的时候返回头结点
        if (node == null || node.next == null){
            return node;
        }
        Node slow = node.next;
        Node fast = node.next;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 输入链表头节点，奇数长度返回中点前一个，偶数长度返回上中点前一个
    public static Node midOrUpPreNode(Node node){
        if (node == null || node.next == null || node.next.next == null){
            return null;
        }
        Node slow = node;
        Node fast = node.next.next;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 输入链表头节点，奇数长度返回中点前一个，偶数长度返回下中点前一个
    public static Node midOrDownPreNode(Node node){
        if (node == null || node.next == null) {
            return null;
        }
        Node slow = node;
        Node fast = node.next;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node right1(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        ArrayList<Node> arr = new ArrayList<>();
        while (cur != null) {
            arr.add(cur);
            cur = cur.next;
        }
        return arr.get((arr.size() - 1) / 2);
    }

    public static Node right2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        ArrayList<Node> arr = new ArrayList<>();
        while (cur != null) {
            arr.add(cur);
            cur = cur.next;
        }
        return arr.get(arr.size() / 2);
    }

    public static Node right3(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node cur = head;
        ArrayList<Node> arr = new ArrayList<>();
        while (cur != null) {
            arr.add(cur);
            cur = cur.next;
        }
        return arr.get((arr.size() - 3) / 2);
    }

    public static Node right4(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node cur = head;
        ArrayList<Node> arr = new ArrayList<>();
        while (cur != null) {
            arr.add(cur);
            cur = cur.next;
        }
        return arr.get((arr.size() - 2) / 2);
    }
}
