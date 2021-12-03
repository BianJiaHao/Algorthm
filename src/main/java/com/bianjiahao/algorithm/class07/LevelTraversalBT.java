package com.bianjiahao.algorithm.class07;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 按层遍历二叉树
 * @author BianJiaHao
 */
public class LevelTraversalBT {

    public static class Node {

        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }

    public static void level(Node head){
        if (head == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.value);
            if (cur.left != null){
                queue.add(cur.left);
            }
            if (cur.right != null){
                queue.add(cur.right);
            }
        }
    }
}
