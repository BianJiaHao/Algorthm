package com.bianjiahao.algorithm.class10;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Dijkstra问题
 * @author Obito
 */
public class Dijkstra {

    public static HashMap<Node,Integer> dijkstra1(Node head){
        HashMap<Node, Integer> distanceMap = new HashMap<>(16);
        distanceMap.put(head,0);
        HashSet<Node> selectNodeSet = new HashSet<>();
        Node minNode = getMinDistanceAndUseUnSelect(distanceMap,selectNodeSet);
        while (minNode != null){
            Integer distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                if (!distanceMap.containsKey(toNode)){
                    distanceMap.put(toNode, edge.weight + distance);
                }else {
                    distanceMap.put(toNode,Math.min(distanceMap.get(toNode),edge.weight + distance));
                }
            }
            selectNodeSet.add(minNode);
            minNode = getMinDistanceAndUseUnSelect(distanceMap,selectNodeSet);
        }
        return distanceMap;
    }

    private static Node getMinDistanceAndUseUnSelect(HashMap<Node, Integer> distanceMap, HashSet<Node> selectNodeSet) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!selectNodeSet.contains(node) && distance < minDistance){
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }

    public static class NodeRecord {
        public Node node;
        public int distance;

        public NodeRecord(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static class NodeHeap {

        private Node[] nodes;
        private HashMap<Node,Integer> heapIndexMap;
        private HashMap<Node,Integer> distanceMap;
        private int size;

        public boolean isEmpty() {
            return size == 0;
        }

        public NodeHeap(int size) {
            nodes = new Node[size];
            heapIndexMap = new HashMap<>(16);
            distanceMap = new HashMap<>(16);
            size = 0;
        }

        public void addOrUpdateOrIgnore(Node node,int distance) {
            if (inHead(node)){
                distanceMap.put(node,Math.min(distanceMap.get(node),distance));
                insertHeapify(node,heapIndexMap.get(node));
            }
            if (!isEntered(node)){
                nodes[size] = node;
                heapIndexMap.put(node,size);
                distanceMap.put(node,distance);
                insertHeapify(node,size++);
            }
        }

        public NodeRecord pop() {
            NodeRecord nodeRecord = new NodeRecord(nodes[0], distanceMap.get(nodes[0]));
            swap(0,size - 1);
            heapIndexMap.put(nodes[size - 1],-1);
            distanceMap.remove(nodes[size - 1]);
            nodes[size - 1] = null;
            heapify(0,--size);
            return nodeRecord;

        }

        private void heapify(int index, int size) {
            int left = index * 2 + 1;
            while (left < size){
                int smallest = left + 1 < size && distanceMap.get(nodes[left + 1]) < distanceMap.get(nodes[left]) ? left + 1 : left;
                smallest = distanceMap.get(nodes[smallest]) < distanceMap.get(nodes[index]) ? smallest : index;
                if (smallest == index){
                    break;
                }
                swap(index,smallest);
                index = smallest;
                left = index * 2 + 1;
            }
        }

        private void insertHeapify(Node node, int index) {
            while (distanceMap.get(nodes[index]) < distanceMap.get(nodes[(index - 1) / 2])){
                swap(index,(index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        private void swap(int index1, int index2) {
            heapIndexMap.put(nodes[index1],index2);
            heapIndexMap.put(nodes[index2],index1);
            Node tmp = nodes[index1];
            nodes[index1] = nodes[index2];
            nodes[index2] = tmp;
        }

        private boolean isEntered(Node node) {
            return heapIndexMap.containsKey(node);
        }

        private boolean inHead(Node node) {
            return isEntered(node) && heapIndexMap.get(node) != -1;
        }
    }


}
