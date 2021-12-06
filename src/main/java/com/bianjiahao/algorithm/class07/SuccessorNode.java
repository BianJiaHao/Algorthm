package com.bianjiahao.algorithm.class07;

/**
 * 找到某个节点的后继节点
 * @author BianJiaHao
 */
public class SuccessorNode {

    public static class Node {

        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getSuccessorNode(Node node){

        if (node == null){
            return node;
        }

        if (node.right != null){
            return getLeftMost(node);
        }else {
            Node parent = node.parent;
            while (parent != null && parent.left != node){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static Node getLeftMost(Node node) {
        if (node == null){
            return node;
        }
        while (node.left != null){
            node = node.left;
        }
        return node;
    }
}
