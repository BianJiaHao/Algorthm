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
}
