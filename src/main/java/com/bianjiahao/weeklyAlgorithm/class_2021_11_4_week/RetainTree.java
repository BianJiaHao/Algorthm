package com.bianjiahao.weeklyAlgorithm.class_2021_11_4_week;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵多叉树的头节点head，每个节点只有黑白两色
 * 所有黑节点都保留，所有从头节点到黑节点路径上的点都保留
 * 返回处理后树的头节点
 * @author admin
 */
public class RetainTree {

    public static class Node {

        public int value;
        public boolean retain;
        public List<Node> nexts;

        public Node(int value,boolean retain) {
            this.value = value;
            this.retain = retain;
            nexts = new ArrayList<>();
        }
    }

    public static Node retain(Node head) {

        if (head.nexts.isEmpty()) {
            return head.retain ? head : null;
        }
        List<Node> newNexts = new ArrayList<>();
        for (Node next : head.nexts) {
            Node newNext = retain(next);
            if (newNext != null) {
                newNexts.add(newNext);
            }
        }

        if (!newNexts.isEmpty() || head.retain) {
            head.nexts = newNexts;
            return head;
        }
        return null;
    }



}
