package com.bianjiahao.algorithm.class10;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * P算法
 * @author Obito
 */
public class Prim {

    public static class MyComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> primMST(Graph graph) {
        PriorityQueue<Edge> queue = new PriorityQueue<>(new MyComparator());
        HashSet<Node> set = new HashSet<>();
        HashSet<Edge> result = new HashSet<>();
        for (Node node : graph.nodes.values()) {
            if (!set.contains(node)){
                set.add(node);
                for (Edge edge : node.edges) {
                    queue.add(edge);
                }
                while (!queue.isEmpty()){
                    Edge edge = queue.poll();
                    Node toNode = edge.to;
                    if (!set.contains(toNode)){
                        set.add(toNode);
                        result.add(edge);
                        for (Edge nextEdge : toNode.edges) {
                            queue.add(nextEdge);
                        }
                    }
                }
            }
            break;
        }
        return result;
    }
}
