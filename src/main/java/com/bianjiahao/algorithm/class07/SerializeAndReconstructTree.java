package com.bianjiahao.algorithm.class07;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化和反序列化
 * @author BianJiaHao
 */
public class SerializeAndReconstructTree {

    public static class Node {

        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }

    public static Queue<String> preSerial(Node head){
        Queue<String> ans = new LinkedList<>();
        pres(head,ans);
        return ans;
    }

    public static void pres(Node head, Queue<String> ans) {
        if (head == null){
            ans.add(null);
        }else {
            ans.add(String.valueOf(head.value));
            pres(head.left,ans);
            pres(head.right,ans);
        }
    }

    public static Node buildByPreQueue(Queue<String> preList){
        if (preList == null || preList.size() == 0){
            return null;
        }
        return preb(preList);
    }

    public static Node preb(Queue<String> preList) {
        String cur = preList.poll();
        if (cur == null){
            return null;
        }
        Node node = new Node(Integer.parseInt(cur));
        node.left = preb(preList);
        node.right = preb(preList);
        return node;
    }

    public static Queue<String> levelSerial(Node head){
        Queue<String> ans = new LinkedList<>();
        if (head == null){
            ans.add(null);
        }else {
            ans.add(String.valueOf(head.value));
            Queue<Node> queue = new LinkedList<>();
            queue.add(head);
            while (!queue.isEmpty()){
                head = queue.poll();
                if (head.left != null){
                    ans.add(String.valueOf(head.left.value));
                    queue.add(head.left);
                }else {
                    ans.add(null);
                }
                if (head.right != null){
                    ans.add(String.valueOf(head.right.value));
                    queue.add(head.right);
                }else {
                    ans.add(null);
                }
            }
        }
        return ans;
    }

    public static Node buildByLevelQueue(Queue<String> levelList){
        if (levelList == null || levelList.size() == 0){
            return null;
        }
        Node head = generateNode(levelList.poll());
        Queue<Node> queue = new LinkedList<>();
        if (head != null){
            queue.add(head);
        }
        Node node = null;
        while (!queue.isEmpty()){
            node = queue.poll();
            node.left = generateNode(levelList.poll());
            node.right = generateNode(levelList.poll());
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
        return head;

    }

    public static Node generateNode(String val) {
        if (val == null) {
            return null;
        }
        return new Node(Integer.valueOf(val));
    }
}
