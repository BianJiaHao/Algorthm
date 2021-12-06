package com.bianjiahao.algorithm.class07;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大宽度
 * @author BianJiaHao
 */
public class TreeMaxWidth {

    public static class Node{

        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int maxWidthUseMap(Node head){
        if (head == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Integer> map = new HashMap<>();
        queue.add(head);
        map.put(head,1);
        int curLevel = 1;
        int max = 0;
        int curLevelNode = 0;
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            Integer curNodeLevel = map.get(cur);
            if (cur.left != null){
                queue.add(cur.left);
                map.put(cur.left, curNodeLevel + 1);
            }
            if (cur.right != null){
                queue.add(cur.right);
                map.put(cur.right,curNodeLevel + 1);
            }
            if (curNodeLevel == curLevel){
                curLevelNode ++;
            }else {
                max = Math.max(max,curLevelNode);
                curLevelNode = 1;
                curLevel ++;
            }
        }
        max = Math.max(max,curLevelNode);
        return max;
    }

    public static int maxWidthNoMap(Node head){

        if (head == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node curEnd = head;
        Node nextEnd = null;
        int max = 0;
        int curLevelNodes = 0;
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            if (cur.left != null){
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null){
                queue.add(cur.right);
                nextEnd = cur.right;
            }
            curLevelNodes++;
            if (curEnd == cur){
                max = Math.max(max,curLevelNodes);
                curEnd = nextEnd;
                curLevelNodes = 0;
            }
        }
        return max;
    }
}
