package com.bianjiahao.review.first;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author admin
 */
public class CopyListWithRand {

    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return value == node.value && Objects.equals(next, node.next) && Objects.equals(rand, node.rand);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, next, rand);
        }
    }

    public static Node copyListWithRandWithMap(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>(16);
        Node cur = head;
        while (cur != null) {
            map.put(cur,new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static Node copyListWithRandOptimalSolution(Node head) {
       if (head == null) {
           return null;
       }
       Node cur = head;
       Node next;
       while (cur != null) {
           next = cur.next;
           cur.next = new Node(cur.value);
           cur.next.next = next;
           cur = next;
       }
       cur = head;
       Node res = head.next;
       Node copyNode;
       while (cur != null) {
           next = cur.next.next;
           copyNode = cur.next;
           cur.next = next;
           copyNode.next = next;
           cur = next;
       }
       return res;
    }
}
