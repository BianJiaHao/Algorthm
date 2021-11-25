package com.bianjiahao.algorithm.class06;

import org.w3c.dom.Node;

import java.util.HashMap;

/**
 * 拷贝一个特殊的单链表
 * @author BianJiaHao
 */
public class CopyListWithRandom {

    public static class Node {
        public int value;
        public Node random;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node copyListWithRand1(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null){
            map.put(cur,new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static Node copyListWithRand2(Node head) {
        if (head == null){
            return null;
        }
        Node cur = head;
        Node next = null;
        while (cur != null){
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node copyNode = null;
        while (cur != null){
           next = cur.next.next;
           copyNode = cur.next;
           copyNode.random = cur.random == null ? null : cur.random.next;
           cur = next;
        }
        Node res = head.next;
        cur = head;
        while (cur != null){
            next = cur.next.next;
            copyNode = cur.next;
            cur.next = next;
            copyNode.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }

}
