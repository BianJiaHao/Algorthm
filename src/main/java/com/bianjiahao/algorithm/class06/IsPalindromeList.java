package com.bianjiahao.algorithm.class06;

import java.util.Stack;

/**
 * 判断一个单链表是否为回文结构
 * @author BianJiaHao
 */
public class IsPalindromeList {

    public static class Node{
        public int value;
        public Node next;
        public Node(int val){
            this.value = val;
        }
    }

    // 使用栈的方式 额外空间复杂度为O(N)
    public static Boolean isPalindromeList(Node head){
        Stack<Node> nodes = new Stack<>();
        Node cur = head;
        while (cur != null){
            nodes.push(cur);
            cur = cur.next;
        }
        while (head != null){
            if (head.value != nodes.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // 用近似中点+栈的方法，额外空间复杂度相较于单纯使用栈的方法减少一半
    public static Boolean isPalindromeList2(Node head){
        if (head == null || head.next == null){
            return false;
        }
        Node slow = head.next;
        Node fast = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        Stack<Node> stack = new Stack<>();
        while (slow != null){
            stack.push(slow);
            slow = slow.next;
        }
        while (!stack.isEmpty()){
            if (stack.pop().value != head.value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static Boolean isPalindromeList3(Node head){
        if (head == null || head.next == null){
            return false;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        Node help = null;
        while (fast != null){
            help = fast.next;
            fast.next = slow;
            slow = fast;
            fast = help;
        }
        help = slow;
        fast = head;
        Boolean res = true;
        while (slow != null && fast != null){
            if (slow.value != fast.value){
                res = false;
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        slow = help.next;
        help.next = null;
        while (slow != null){
            fast = slow.next;
            slow.next = help;
            help = slow;
            slow = fast;
        }
        return res;
    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;
        Node node3 = new Node(3);
        node2.next = node3;
        Node node4 = new Node(2);
        node3.next = node4;
        Node node5 = new Node(1);
        node4.next = node5;
        node5.next = null;
        System.out.println(isPalindromeList2(node1));

    }
}
