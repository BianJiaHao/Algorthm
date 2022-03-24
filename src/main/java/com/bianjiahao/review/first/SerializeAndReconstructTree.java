package com.bianjiahao.review.first;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndReconstructTree {

    public static class Node {
       public int value;
       public Node left;
       public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Queue<String> preSerial(Node head) {
        Queue<String> ans = new LinkedList<>();
        pre(ans,head);
        return ans;
    }

    public static void pre(Queue<String> queue,Node head) {
        if (head == null) {
            queue.add(null);
        }else {
            queue.add(Integer.toString(head.value));
            pre(queue,head.left);
            pre(queue,head.right);
        }
    }

    public static Node buildByPreQueue(Queue<String> queue) {
        if (queue == null || queue.size() == 0) {
            return null;
        }
        return preb(queue);
    }

    public static Node preb(Queue<String> queue) {
        String cur = queue.poll();
        if (cur == null) {
            return null;
        }
        Node node = new Node(Integer.parseInt(cur));
        node.left = preb(queue);
        node.right = preb(queue);
        return node;
    }

    public static Queue<String> levelSerial(Node head) {
        Queue<String> ans = new LinkedList<>();
        if (head == null) {
            ans.add(null);
        }else {
            Queue<Node> queue = new LinkedList<>();
            queue.add(head);
            ans.add(Integer.toString(head.value));
            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                    ans.add(Integer.toString(cur.left.value));
                }else {
                    ans.add(null);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                    ans.add(Integer.toString(cur.right.value));
                }else {
                    ans.add(null);
                }
            }
        }
        return ans;
    }

    public static Node buildByLevelQueue(Queue<String> levelList) {
        if (levelList == null || levelList.size() == 0) {
            return null;
        }
        Node head = generateNode(levelList.poll());
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            cur.left = generateNode(levelList.poll());
            cur.right = generateNode(levelList.poll());
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        return head;
    }

    public static Node generateNode(String val) {
        if (val == null) {
            return null;
        }else {
            return new Node(Integer.parseInt(val));
        }
    }
}
